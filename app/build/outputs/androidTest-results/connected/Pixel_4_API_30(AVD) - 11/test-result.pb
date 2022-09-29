
ύ>
n
MainActivityEspressoTestcom.example.trainingactivitymainActivityEspressoTest2α–€¥¨®:Δα–ΐψεΎ8
ςandroidx.test.espresso.base.DefaultFailureHandler$AssertionFailedWithCauseError: 'an instance of android.widget.TextView and view.getText() with or without transformation to match: is "You win!"' doesn't match the selected view.
Expected: an instance of android.widget.TextView and view.getText() with or without transformation to match: is "You win!"
Got: view.getText() was "Correct sequence! Starting next sequence!" transformed text was "Correct sequence! Starting next sequence!"
View Details: MaterialTextView{id=2131231170, res-name=textview, visibility=VISIBLE, width=1080, height=53, has-focus=false, has-focusable=false, has-window-focus=true, is-clickable=false, is-enabled=true, is-focused=false, is-focusable=false, is-layout-requested=false, is-selected=false, layout-params=androidx.constraintlayout.widget.ConstraintLayout$LayoutParams@654d990, tag=null, root-is-layout-requested=false, has-input-connection=false, x=0.0, y=678.0, text=Correct sequence! Starting next sequence!, input-type=0, ime-target=false, has-links=false}

at dalvik.system.VMStack.getThreadStackTrace(Native Method)
at java.lang.Thread.getStackTrace(Thread.java:1736)
at androidx.test.espresso.base.DefaultFailureHandler.getUserFriendlyError(DefaultFailureHandler.java:12)
at androidx.test.espresso.base.DefaultFailureHandler.handle(DefaultFailureHandler.java:7)
at androidx.test.espresso.ViewInteraction.waitForAndHandleInteractionResults(ViewInteraction.java:5)
at androidx.test.espresso.ViewInteraction.check(ViewInteraction.java:12)
at com.example.trainingactivity.MainActivityEspressoTest.mainActivityEspressoTest(MainActivityEspressoTest.kt:61)
... 29 trimmed
Caused by: junit.framework.AssertionFailedError: 'an instance of android.widget.TextView and view.getText() with or without transformation to match: is "You win!"' doesn't match the selected view.
Expected: an instance of android.widget.TextView and view.getText() with or without transformation to match: is "You win!"
Got: view.getText() was "Correct sequence! Starting next sequence!" transformed text was "Correct sequence! Starting next sequence!"
View Details: MaterialTextView{id=2131231170, res-name=textview, visibility=VISIBLE, width=1080, height=53, has-focus=false, has-focusable=false, has-window-focus=true, is-clickable=false, is-enabled=true, is-focused=false, is-focusable=false, is-layout-requested=false, is-selected=false, layout-params=androidx.constraintlayout.widget.ConstraintLayout$LayoutParams@654d990, tag=null, root-is-layout-requested=false, has-input-connection=false, x=0.0, y=678.0, text=Correct sequence! Starting next sequence!, input-type=0, ime-target=false, has-links=false}

at androidx.test.espresso.matcher.ViewMatchers.assertThat(ViewMatchers.java:16)
at androidx.test.espresso.assertion.ViewAssertions$MatchesViewAssertion.check(ViewAssertions.java:11)
at androidx.test.espresso.ViewInteraction$SingleExecutionViewAssertion.check(ViewInteraction.java:2)
at androidx.test.espresso.ViewInteraction$2.call(ViewInteraction.java:12)
at androidx.test.espresso.ViewInteraction$2.call(ViewInteraction.java:1)
at java.util.concurrent.FutureTask.run(FutureTask.java:266)
at android.os.Handler.handleCallback(Handler.java:938)
at android.os.Handler.dispatchMessage(Handler.java:99)
at android.os.Looper.loop(Looper.java:223)
at android.app.ActivityThread.main(ActivityThread.java:7656)
at java.lang.reflect.Method.invoke(Native Method)
at com.android.internal.os.RuntimeInit$MethodAndArgsCaller.run(RuntimeInit.java:592)
at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:947)$junit.framework.AssertionFailedErrorςandroidx.test.espresso.base.DefaultFailureHandler$AssertionFailedWithCauseError: 'an instance of android.widget.TextView and view.getText() with or without transformation to match: is "You win!"' doesn't match the selected view.
Expected: an instance of android.widget.TextView and view.getText() with or without transformation to match: is "You win!"
Got: view.getText() was "Correct sequence! Starting next sequence!" transformed text was "Correct sequence! Starting next sequence!"
View Details: MaterialTextView{id=2131231170, res-name=textview, visibility=VISIBLE, width=1080, height=53, has-focus=false, has-focusable=false, has-window-focus=true, is-clickable=false, is-enabled=true, is-focused=false, is-focusable=false, is-layout-requested=false, is-selected=false, layout-params=androidx.constraintlayout.widget.ConstraintLayout$LayoutParams@654d990, tag=null, root-is-layout-requested=false, has-input-connection=false, x=0.0, y=678.0, text=Correct sequence! Starting next sequence!, input-type=0, ime-target=false, has-links=false}

at dalvik.system.VMStack.getThreadStackTrace(Native Method)
at java.lang.Thread.getStackTrace(Thread.java:1736)
at androidx.test.espresso.base.DefaultFailureHandler.getUserFriendlyError(DefaultFailureHandler.java:12)
at androidx.test.espresso.base.DefaultFailureHandler.handle(DefaultFailureHandler.java:7)
at androidx.test.espresso.ViewInteraction.waitForAndHandleInteractionResults(ViewInteraction.java:5)
at androidx.test.espresso.ViewInteraction.check(ViewInteraction.java:12)
at com.example.trainingactivity.MainActivityEspressoTest.mainActivityEspressoTest(MainActivityEspressoTest.kt:61)
... 29 trimmed
Caused by: junit.framework.AssertionFailedError: 'an instance of android.widget.TextView and view.getText() with or without transformation to match: is "You win!"' doesn't match the selected view.
Expected: an instance of android.widget.TextView and view.getText() with or without transformation to match: is "You win!"
Got: view.getText() was "Correct sequence! Starting next sequence!" transformed text was "Correct sequence! Starting next sequence!"
View Details: MaterialTextView{id=2131231170, res-name=textview, visibility=VISIBLE, width=1080, height=53, has-focus=false, has-focusable=false, has-window-focus=true, is-clickable=false, is-enabled=true, is-focused=false, is-focusable=false, is-layout-requested=false, is-selected=false, layout-params=androidx.constraintlayout.widget.ConstraintLayout$LayoutParams@654d990, tag=null, root-is-layout-requested=false, has-input-connection=false, x=0.0, y=678.0, text=Correct sequence! Starting next sequence!, input-type=0, ime-target=false, has-links=false}

at androidx.test.espresso.matcher.ViewMatchers.assertThat(ViewMatchers.java:16)
at androidx.test.espresso.assertion.ViewAssertions$MatchesViewAssertion.check(ViewAssertions.java:11)
at androidx.test.espresso.ViewInteraction$SingleExecutionViewAssertion.check(ViewInteraction.java:2)
at androidx.test.espresso.ViewInteraction$2.call(ViewInteraction.java:12)
at androidx.test.espresso.ViewInteraction$2.call(ViewInteraction.java:1)
at java.util.concurrent.FutureTask.run(FutureTask.java:266)
at android.os.Handler.handleCallback(Handler.java:938)
at android.os.Handler.dispatchMessage(Handler.java:99)
at android.os.Looper.loop(Looper.java:223)
at android.app.ActivityThread.main(ActivityThread.java:7656)
at java.lang.reflect.Method.invoke(Native Method)
at com.android.internal.os.RuntimeInit$MethodAndArgsCaller.run(RuntimeInit.java:592)
at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:947)"ο

logcatandroidΩ
Φ/Users/r.kim/AndroidStudioProjects/TrainingActivity/app/build/outputs/androidTest-results/connected/Pixel_4_API_30(AVD) - 11/logcat-com.example.trainingactivity.MainActivityEspressoTest-mainActivityEspressoTest.txt"©

device-infoandroid
‹/Users/r.kim/AndroidStudioProjects/TrainingActivity/app/build/outputs/androidTest-results/connected/Pixel_4_API_30(AVD) - 11/device-info.pb"ª

device-info.meminfoandroid‡
„/Users/r.kim/AndroidStudioProjects/TrainingActivity/app/build/outputs/androidTest-results/connected/Pixel_4_API_30(AVD) - 11/meminfo"ª

device-info.cpuinfoandroid‡
„/Users/r.kim/AndroidStudioProjects/TrainingActivity/app/build/outputs/androidTest-results/connected/Pixel_4_API_30(AVD) - 11/cpuinfo*
c
test-results.logOcom.google.testing.platform.runtime.android.driver.AndroidInstrumentationDriver
•/Users/r.kim/AndroidStudioProjects/TrainingActivity/app/build/outputs/androidTest-results/connected/Pixel_4_API_30(AVD) - 11/testlog/test-results.log 2
text/plain