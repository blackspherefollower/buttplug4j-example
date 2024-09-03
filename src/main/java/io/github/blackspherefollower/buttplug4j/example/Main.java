package io.github.blackspherefollower.buttplug4j.example;

import io.github.blackspherefollower.buttplug4j.client.*;
import io.github.blackspherefollower.buttplug4j.connectors.jetty.websocket.client.ButtplugClientWSClient;
import io.github.blackspherefollower.buttplug4j.protocol.ButtplugMessage;
import io.github.blackspherefollower.buttplug4j.protocol.messages.Error;

import java.net.URI;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) throws Exception {
        // Create a client object: this holds the connection to Intiface,
        // so define it somewhere where it won't be GC'ed before you're done
        ButtplugClientWSClient client = new ButtplugClientWSClient("Buttplug4J Example");

        // Add callbacks (optional, but useful)
        client.setOnConnected(new IConnectedEvent() {
            @Override
            public void onConnected(ButtplugClient buttplugClient) {
                // Called on successful connection
                System.out.println("Connected");
            }
        });
        client.setErrorReceived(new IErrorEvent() {
            @Override
            public void errorReceived(Error error) {
                // Called for any errors - this includes those sent from Intiface
                // and also exceptions raised on other threads that may need handling
                System.out.println("Error: " + error);
            }
        });
        client.setScanningFinished(new IScanningEvent() {
            @Override
            public void scanningFinished() {
                // Called when Intiface stops scanning for devices
                System.out.println("Scanning finished");
            }
        });
        IDeviceEvent deviceEventHandler = new IDeviceEvent() {
            @Override
            public void deviceAdded(ButtplugClientDevice buttplugClientDevice) {
                // Called when Intiface connects to a device
                System.out.println("Device added: " + buttplugClientDevice.getName() + "(" + buttplugClientDevice.getDeviceIndex() + ")");
            }

            @Override
            public void deviceRemoved(long l) {
                // Called when a device disconnects from Intiface
                System.out.println("Device removed: " + l);
            }
        };
        client.setDeviceAdded(deviceEventHandler);
        client.setDeviceRemoved(deviceEventHandler);

        // Connect to Intiface (default address/port is hardcoded here but should be configurable)
        client.connect(new URI("ws://localhost:12345/buttplug"));

        // Tell Intiface to start scanning for devices and wait 5 seconds
        client.startScanning();
        Thread.sleep(5000);

        // List the connected devices
        for (ButtplugClientDevice dev : client.getDevices()) {
            System.out.println("Device: " + dev.getName() + "(" + dev.getDeviceIndex() + ")");
        }

        // Iterate over the devices and make them all vibrate at 50%
        //
        // Commands are sent async, so collect an array of the Futures and join them after
        // all the vibration commands have been scheduled
        List<Future<ButtplugMessage>> commands = new LinkedList<>();
        for (ButtplugClientDevice dev : client.getDevices()) {
            if (dev.getScalarVibrateCount() > 0) {
                try {
                    commands.add(dev.sendScalarVibrateCmd(0.5));
                } catch (ButtplugDeviceException e) {
                    // This could be a "device disconnected" error or a "connection lost" error...
                    System.out.println("Error: " + e.getMessage());
                }
            }
        }
        // Join the command send threads
        for(Future<ButtplugMessage> cmd : commands) {
            try {
                cmd.get();
            } catch (Exception e) {
                // This could be a "device disconnected" error or a "connection lost" error...
                System.out.println("Error: " + e.getMessage());
            }
        }
        Thread.sleep(1000);

        // Stop all devices
        client.stopAllDevices();

        // Disconnect to close the connection to Intiface
        client.disconnect();
    }
}