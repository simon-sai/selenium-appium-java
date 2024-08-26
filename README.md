## How to run with Maven

- Run all runner: 
  - `mvn clean test`

- Run with one runner
  - `mvn clean test -P demoWeb`
  - `mvn clean test -P demoApi`

- Run test with tag @wip
  - `mvn clean test -P wip`

## Appium require
- We need appium node js with available drivers:
  - uiautomator2@3.7.7 (automationName 'UiAutomator2')
  - espresso@3.3.1 (automationName 'Espresso')

## How to get current bundle id of app
- Get all devices connected
  - `adb devices`
- Get current active app info
  - `adb shell dumpsys window windows`


