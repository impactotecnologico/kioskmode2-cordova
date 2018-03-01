# Kioskmode2 - Cordova
by [Impacto Tecnol&oacute;gico](http://www.impactotecnologico.net)

|||
|--|--|
|Title|**KioskMode2**
|Description|A cordova plugin to convert a simple app in a launcher app
|Support|**only for Android**

---

This plugin defines a global `window.plugins.KPlugin` object, which provides android configurations for any simple app to convert it in a launcher. Is very useful for Digital Signage clients, parental control apps, etc.


## 0 Index

1. [Description](#1-description)
2. [Installation](#2-installation)
3. [Usage](#3-usage)
4. [Demo](#4-demo)
5. [Credits](#5-credits)
6. [License](#6-license)

## 1 Description
A Kiosk App prevent any other applications to run in the foreground. An app with **kioskmode2-cordova** plugin disable various Android features that can be used to leave your app. The following features are affected:
-   The home button
-   The recent apps button

**Back Button**
This plugin doesn't implement any disable feature for the back button natively because each app is totally different, then, is possible to implement the back button restriction at final app level using a confirm dialog, two or many taps in backbutton, etc. You can check our [Demo](#-demo)

## 2 Installation

### Android Platform
This plugin edit the **android Manifest** file therefore, is necessary to have the Android platform already added. You can add this with:

`$ ionic cordova platform add android`

Now yo can install the plugin normally:

### Automatically (CLI)
This requires cordova 7.0+
```
$ cordova plugin add kioskmode2-cordova
$ cordova prepare
```

## 3 Usage

This plugin is very simple to use. After installation, you can use it inside your app via `window.plugins`. A recommended wrapper for this object in **Typescript** is available in [DZone](https://dzone.com/articles/angular-2-how-do-i-get-a-reference-to-the-window-o)

:warning: Remember that this is a kiosk-mode plugin, then is not easily to exit of an app with this.

The plugin has two functions to allow quit temporally or definitely. Both functions need **seven (7)** user interactions (:point_up: taps in a button or image, etc) to be executed.

### showApps
This function will show a list of any installed app in the device, then, the user can get access to to another app to do any action and go back to the kiosk-app
`window.plugins.KPlugin.showApps();`

### uninstall
This function is a backdoor to allow a self uninstall
`window.plugins.KPlugin.unistall();`


## 4 Demo
An Ionic demo project is available here: https://github.com/impactotecnologico/kioskmode2-demo

## 5 Credits
Android and Javascript coder: [Jose Julian Ariza](https://github.com/impactotecnologico)

## 6 License

[The MIT License (MIT)](http://www.opensource.org/licenses/mit-license.html)

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.