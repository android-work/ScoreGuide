# ScoreGuide
引导用户进入gp进行应用评分的操作，并响应相关事件
### Step 1. Add the JitPack repository to your build file<br>
allprojects {<br>
		repositories {<br>
			...<br>
			maven { url 'https://jitpack.io' }<br>
		}<br>
	}<br>
  
### Step 2. Add the dependency<br>
dependencies {<br>
	        implementation 'com.github.android-work:ScoreGuide:1.0.3'<br>
	}
  
  
 ### Step 3.在清单文件中注册activity<br>
 <activity android:name="com.work.load.scoreguide.FeedbackActivity"/> <br>
 
 ### step 4.创建弹窗对象\<br>
 SccorePopupWindow scorePopupWindow = new SccorePopupWindow(this);<br>
 scorePopupWindow.show("父布局所在view","app名字");
