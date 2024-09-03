# Buttplug for Java - Usage Example

[![Build Status](https://github.com/blackspherefollower/buttplug4j-example/actions/workflows/gradle.yml/badge.svg?branch=master)](https://github.com/blackspherefollower/buttplug4j/actions/workflows/gradle.yml) [![Patreon donate button](https://img.shields.io/badge/patreon-donate-yellow.svg)](https://www.patreon.com/blackspherefollower)

This repo contains a very simple example usage of [buttplug4j](https://github.com/blackspherefollower/buttplug4j), including Gradle build files demonstrating the dependency import:
```groovy
dependencies {
    implementation 'io.github.blackspherefollower:buttplug4j.connectors.jetty.websocket.client:3.1.105'
}
```

I don't plan to add an example Maven pom, but the rough equivalent dependency is:
```xml
<dependencies>
    <dependency>
        <groupId>io.github.blackspherefollower</groupId>
        <artifactId>buttplug4j.connectors.jetty.websocket.client</artifactId>
        <version>3.1.105</version>
    </dependency>
</dependencies>
```

Note that both Gradle and Maven will handle the rest of the dependencies, including the buttplug4j core library.

The rest of the example can be found [here](src/main/java/io/github/blackspherefollower/buttplug4j/example/Main.java)


## Support The Project

If you find this project helpful, you can
[support my projects via Patreon](http://patreon.com/blackspherefollower)!
Every donation helps us afford more hardware to reverse, document, and
write code for!

## License

Buttplug for Java is BSD licensed.

    Copyright (c) 2016-2024, BlackSphereFollower
    All rights reserved.
    
    Redistribution and use in source and binary forms, with or without
    modification, are permitted provided that the following conditions are met:
    
    * Redistributions of source code must retain the above copyright notice, this
      list of conditions and the following disclaimer.
    
    * Redistributions in binary form must reproduce the above copyright notice,
      this list of conditions and the following disclaimer in the documentation
      and/or other materials provided with the distribution.
    
    * Neither the name of buttplug nor the names of its
      contributors may be used to endorse or promote products derived from
      this software without specific prior written permission.
    
    THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
    AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
    IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
    DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
    FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
    DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
    SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
    CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
    OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
    OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
