"# EasyPrintLogGUI" 

[![Build Status](https://travis-ci.org/lionants02/EasyPrintLogGUI.svg?branch=master)](https://travis-ci.org/lionants02/EasyPrintLogGUI.ini) [![Release](https://jitpack.io/v/lionants02/EasyPrintLogGUI.svg)](https://jitpack.io/#lionants02/EasyPrintLogGUI)  
[![ktlint](https://img.shields.io/badge/code%20style-%E2%9D%A4-FF4081.svg)](https://ktlint.github.io/)

เพิ่ม JitPack repository ที่ build script
```
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```

เพิ่ม dependency
```
dependencies {
    implementation "com.github.lionants02:EasyPrintLogGUI:$latestVersion"
}
```

ใช้
```$xslt
    val printLog = EasyPrintLogGUI("My Title")
    printLog.text = "auto append line"
    
    val printLog2 = EasyPrintLogGUI("My Title",lineLimit = 2)
    printLog2.text = "auto append line1"
    printLog2.text = "auto append line2"
    printLog2.text = "auto append line3 and auto remove line 1"
```
