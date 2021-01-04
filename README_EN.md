![](https://github.com/loperSeven/tablayout-ext/blob/master/image/logo.png)
<br/>
[![](https://jitpack.io/v/loperSeven/tablayout-ext.svg)](https://jitpack.io/#loperSeven/DateTimePicker)&ensp;[![API](https://img.shields.io/badge/API-14%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=21)&ensp;[![](https://img.shields.io/badge/platform-android-green)](https://github.com/loperSeven)&ensp;[![](https://img.shields.io/badge/license-MIT-blue)](https://opensource.org/licenses/MIT)
<br/>
## Language
 [中文](https://github.com/loperSeven/tablayout-ext) | English
<br/>
<br/>
The Zero invasion expansion of com.google.android.material.tabs.TabLayout, allows you to use TabLayout to achieve UI effects more conveniently
<br/>
## Preview
![](https://github.com/loperSeven/tablayout-ext/blob/master/image/demo_gif.gif)
<br/>
## Import
Step 1. add JitPack repository 
```
allprojects {
	repositories {
		...
		maven { url "https://jitpack.io" }
	}
}
```
Step 2. add Gradle
```
dependencies {
    ...
    implementation 'com.google.android.material:material:1.2.1'//google material package
    implementation 'com.github.loperSeven:tablayout-ext:$version'//see the jitpack logo at the top for the specific version, only supports androidx
}


```
## Use
Note: This library is only for some convenience expansions for Tablayout, please refer to the specific Tablayout attributes and usage：[developers wiki](https://developer.android.com/reference/com/google/android/material/tabs/TabLayout)
#### Indicator
```kotlin
  /**
    * setHeight() Set indicator height
    * setWidth() Set indicator width
    * setGravity() = Tablayout.setSelectedTabIndicatorGravity()
    * setColor() = Tablayout.setSelectedTabIndicatorColor()
    */
 tabLayout.buildIndicator<LinearIndicator>()
            .setHeight(22.toPx())
            .setWidth(BaseIndicator.MATCH)
            .setGravity(TabLayout.INDICATOR_GRAVITY_TOP)
            .setColor(ContextCompat.getColor(context!!,R.color.colorAccent))
            .bind()
 /**
    * setPath  [POSITIVE] or [NEGATIVE] 
    */
 tabLayout.buildIndicator<TriangleIndicator>()
            .setPath(TriangleIndicator.Path.NEGATIVE)
            .setWidth(10.toPx())
            .setHeight(10.toPx())
            .setColor(ContextCompat.getColor(context!!,R.color.colorAccent))
            .setGravity(TabLayout.INDICATOR_GRAVITY_TOP)
            .bind()
	    
 /**
    * setDrawable set Drawable or @DrawableRes resId:Int
    * Same as above
    */
  tabLayout.buildIndicator<CustomIndicator>()
            .setDrawable(ContextCompat.getDrawable(context!!,R.mipmap.ic_indicator_fire)!!)
            .bind()
	    
```
If you need to expand more type indicators, you only need to inherit from BaseIndicator, add exclusive attributes, and implement logic in the bind() method.
#### Text
```kotlin
  tabLayout.buildText<BaseText>()
            .setNormalTextBold(true)
            .setSelectTextBold(true)
	    .setNormalTextSize(16f)
            .setSelectTextSize(18f)
            .bind()
```

## ignore
```
-dontwarn com.loper7.tablayout-ext.**
-keep class com.loper7.tablayout-ext.**{*;}
```

## contact me
Issues：[Issues](https://github.com/loperSeven/tablayout-ext/issues)
<br/>
Email：loper7ins@gmail.com
<br/>
## Licenses
```
Copyright 2020 loperSeven

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
```


