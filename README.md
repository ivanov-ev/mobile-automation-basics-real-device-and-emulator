# Sample Tests for Android on Real Devices / Emulator / Browserstack

The commands to run Android tests for the Wikipedia application:

- on real Android devices:

```shell
gradle clean test -DdeviceHost=real
```

- on the Android emulator:

```shell
gradle clean test -DdeviceHost=emulator
```

- on `Browserstack`:

```shell
gradle clean test -DdeviceHost=browserstack
```
