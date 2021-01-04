![](https://github.com/loperSeven/tablayout-ext/blob/master/image/logo.png)
<br/>
[![](https://jitpack.io/v/loperSeven/tablayout-ext.svg)](https://jitpack.io/#loperSeven/DateTimePicker)&ensp;[![API](https://img.shields.io/badge/API-14%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=21)&ensp;[![](https://img.shields.io/badge/platform-android-green)](https://github.com/loperSeven)&ensp;[![](https://img.shields.io/badge/license-MIT-blue)](https://opensource.org/licenses/MIT)
<br/>
## Language
中文 | [English](https://github.com/loperSeven/tablayout-ext/blob/master/README_EN.md)
<br/>
<br/>
google 原生 Tablayout( com.google.android.material.tabs.TabLayout) 零入侵拓展，帮你更便捷的使用原生TabLayout实现一些UI效果
<br/>
## 预览
![](https://github.com/loperSeven/tablayout-ext/blob/master/image/demo_gif.gif)
<br/>
无法加载可前往 [简书](https://www.jianshu.com/p/63fe08bd67da) 或 [掘金](https://juejin.cn/post/6904468604419473422)查看
## 如何引入
Step 1. 添加 JitPack repository 
```
allprojects {
	repositories {
		...
		maven { url "https://jitpack.io" }
	}
}
```
Step 2. 添加 Gradle依赖
```
dependencies {
    ...
    implementation 'com.google.android.material:material:1.2.1'//google material 包
    implementation 'com.github.loperSeven:tablayout-ext:$version'//具体版本请看顶部jitpack标识，仅支持androidx
}


```
## 如何使用
注意：此库只是针对Tablayout做一些便捷性拓展，具体Tablayout属性及用法请查阅：[developers 文档](https://developer.android.com/reference/com/google/android/material/tabs/TabLayout)
#### Indicator
```kotlin
  /**
    * 线性指示器
    * buildIndicator<> 指定指示器类
    * setHeight() 设置指示器高度，默认为tablayout指定tabIndicatorHeight高度
    * setWidth() 设置指示器宽度，若tablayout设置了tabIndicatorFullWidth=true，则默认为tab项宽度，否则为tab实际文字宽度
    * setGravity() 等同于 Tablayout.setSelectedTabIndicatorGravity()
    * setColor() 等同于 Tablayout.setSelectedTabIndicatorColor()
    */
 tabLayout.buildIndicator<LinearIndicator>()
            .setHeight(22.toPx())
            .setWidth(BaseIndicator.MATCH)
            .setGravity(TabLayout.INDICATOR_GRAVITY_TOP)
            .setColor(ContextCompat.getColor(context!!,R.color.colorAccent))
            .bind()
 /**
    * 三角形指示器
    * buildIndicator<> 指定指示器类
    * setPath 设置三角形样式 [POSITIVE]正 [NEGATIVE] 反
    */
 tabLayout.buildIndicator<TriangleIndicator>()
            .setPath(TriangleIndicator.Path.NEGATIVE)//因path为该指示器专有属性，故需先于其他属性调用。
            .setWidth(10.toPx())
            .setHeight(10.toPx())
            .setColor(ContextCompat.getColor(context!!,R.color.colorAccent))
            .setGravity(TabLayout.INDICATOR_GRAVITY_TOP)
            .bind()
	    
 /**
    * 自定义deawable指示器
    * buildIndicator<> 指定指示器类
    * setDrawable 设置指示器drawable 可传入 Drawable 或 @DrawableRes resId:Int
    * 其他属性同上，皆为基础属性
    */
  tabLayout.buildIndicator<CustomIndicator>()
            .setDrawable(ContextCompat.getDrawable(context!!,R.mipmap.ic_indicator_fire)!!)
            .bind()
	    
```
如需拓展更多类型指示器，只需继承自BaseIndicator，添加专属属性，在bind()方法中实现逻辑即可。
#### Text
```kotlin
 /**
    * tab文字设置
    * buildText<> 指定文字设置类
    * setNormalTextBold() 未选中状态下文字是否加粗  默认false
    * setSelectTextBold() 选中状态下文字是否加粗 默认true
    * setNormalTextSize() 未选中状态下文字大小 默认14f（单位sp）
    * setSelectTextSize() 选中状态下文字大小 默认14f（单位sp）
    */
  tabLayout.buildText<BaseText>()
            .setNormalTextBold(true)
            .setSelectTextBold(true)
	    .setNormalTextSize(16f)
            .setSelectTextSize(18f)
            .bind()
```


## 更新计划
* Indicator 动画拓展
* ~~Text 文字大小设置~~

您的star是我更新的动力

## 混淆
```
-dontwarn com.loper7.tablayout-ext.**
-keep class com.loper7.tablayout-ext.**{*;}
```

## 联系我
Issues：[Issues](https://github.com/loperSeven/tablayout-ext/issues)
<br/>
邮箱：loper7@163.com
<br/>
## Licenses
```
Copyright 2020 loperSeven

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
```


