# CustomIndicator

A lightweight ,flexible and optimized indicator for android.

Supports viewpager and recyclerview.

![Alt Text](https://github.com/abhay551/CustomIndicator/blob/master/app/src/main/res/drawable/screenshot.gif)

## GRADLE

1) Add it in your root build.gradle at the end of repositories:

```
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```

2) Add the dependency

```
dependencies {
	        implementation 'com.github.abhay551:CustomIndicator:VERSION-NUMBER'
	}
```

## USAGE

### WITH VIEW PAGER

#### XML

```
    <com.abhay.customindicator.CustomIndicatorView
        android:id="@+id/indicator"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_alignParentBottom="true"
        android:gravity="center"
        app:indicator_bg_color="@android:color/white"
        app:indicator_filled_src="@drawable/filled_indicator"
        app:indicator_unfilled_src="@drawable/unfilled_indicator"
        app:indicator_orientation="horizontal"
        app:indicator_width="10dp"
        app:indicator_height="10dp"
        app:indicator_margin="5dp"/>
```
#### JAVA

```
mIndicator.setIndicatorWithViewPager(mViewPager);
```


### WITH RECYCLERVIEW

#### XML

```
    <com.abhay.customindicator.CustomIndicatorView
        android:id="@+id/indicator"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_alignParentBottom="true"
        android:gravity="center"
        app:indicator_bg_color="@android:color/white"
        app:indicator_filled_src="@drawable/filled_indicator"
        app:indicator_unfilled_src="@drawable/unfilled_indicator"
        app:indicator_orientation="horizontal"
        app:indicator_width="10dp"
        app:indicator_height="10dp"
        app:indicator_margin="5dp"/>
```

#### JAVA

```
mIndicator.setIndicatorWithSnappyRecyclerView(mRecyclerView, snapHelper);
```
