# AndroidMuqing
[![](https://jitpack.io/v/muqing153/AndroidMuqing.svg)](https://jitpack.io/#muqing153/AndroidMuqing)

这是一个 Android 快速项目模块，旨在简化常见的开发任务，提供工具类、基础类封装以及 UI 组件，帮助开发者提高开发效率。

---
## 📦 项目配置
### Android 配置
- `compileSdk`: 35
- `minSdk`: 24
- `targetSdk`: 35
- `sourceCompatibility`: `JavaVersion.VERSION_1_8`
- `targetCompatibility`: `JavaVersion.VERSION_1_8`
- `viewBinding`: true

---

### 🧰 模块使用
#### settings.gradle
    include(':AndroidMuqing')
    project(':AndroidMuqing').projectDir = new File('../AndroidMuqing/library')
#### app/build.gradle-->dependencies{}
    implementation(project(':AndroidMuqing'))
#### jitpack.io
    maven { url 'https://jitpack.io' }
	dependencies {
	        implementation 'com.github.muqing153:AndroidMuqing:Tag'
	}
---

### 引用(api)
    api 'androidx.appcompat:appcompat:1.7.0'
    api('com.google.android.material:material:1.12.0')
    api 'com.squareup.okhttp3:okhttp:4.9.3'
    api('com.github.bumptech.glide:glide:4.16.0')

---
### 🧰 工具类说明
| 类名                                     | 说明              |
|----------------------------------------|-----------------|
| [gj](src/main/java/com/muqing/gj.java) | 工具辅助类，封装了常用类型操作 |
| [wl](src/main/java/com/muqing/wl.java) | 网络连接操作相关工具类     |
| [wj](src/main/java/com/muqing/wj.java) | 文件操作工具类         |
---

### 🧱 基础类封装（支持 ViewBinding）
### 📌 Activity 基类
- `AppCompatActivity<ViewBinding>`  
  → 简洁化 Activity 构建，自动初始化 ViewBinding。
- `BaseActivity<ViewBinding>`  
  → 面向 `RecyclerView` 列表场景的快速构建基类。
### 📌 Fragment 基类

- `BaseFragment<ViewBinding>` / `Fragment`  
  → 简洁化 Fragment 生命周期管理与 ViewBinding 初始化。
---
### 📦 UI 组件（ViewUI）
#### 📌 BottomSheet 可视化触摸组件
- `BottomSheet`  
  → 继承 `BottomSheetDragHandleView` 的可视化触摸组件，优化了触摸反馈和底部弹窗交互体验，支持拖动操作和动态内容展示。
---
### 📦 Dialog 组件
#### 📌 Material 风格输入弹窗
- `DialogEditText`  
  → 基于 `MaterialAlertDialogBuilder` 封装的输入弹窗，提供简洁且易用的用户输入界面。
#### 📌 优化底部弹窗
- `BottomSheetDialog`  
  → 继承自 `com.google.android.material.bottomsheet.BottomSheetDialog`，提供了更加灵活和优化的底部弹窗，实现了更好的交互体验，支持自定义内容和弹出动画。
