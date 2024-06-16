# Sample Tests for Android on Real Devices / Emulator / Browserstack

The commands to run Android tests for the Wikipedia application:

- on the real Android device:

```shell
gradle clean test -DdeviceHost=real
```

- on the `UiAutomator2` emulator:

```shell
gradle clean test -DdeviceHost=emulator
```

- on `Browserstack`:

```shell
gradle clean test -DdeviceHost=browserstack
```


`!` After running the tests, it is necessary to restore the application state as follows:
open "Settings"  - "Apps" - tap the Wikipedia app - "Storage & Cache" - tap "Clear Storage" and "Clear cache".

