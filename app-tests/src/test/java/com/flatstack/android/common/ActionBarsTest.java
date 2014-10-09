package com.flatstack.android.common;

import android.app.Activity;
import android.app.Fragment;
import com.flatstack.android.RobolectricGradleTestRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(RobolectricGradleTestRunner.class)
public class ActionBarsTest {
  Activity activity;

  @Before public void setUp() {
    activity = Robolectric.buildActivity(Activity.class).create().get();
  }

  @Test public void testConfigure() throws Exception {
    Fragment fragment = new Fragment();
    activity.getFragmentManager().beginTransaction().add(fragment, "").commit();
    com.flatstack.android.common.ActionBars.configure(fragment,
        actionBar -> actionBar.setTitle("test"));
    assertThat(activity.getActionBar().getTitle()).isEqualTo("test");
  }

  @Test public void testConfigure1() throws Exception {
    com.flatstack.android.common.ActionBars.configure(activity,
        actionBar -> actionBar.setSubtitle("fuck"));
    assertThat(activity.getActionBar().getSubtitle()).isEqualTo("fuck");
  }
}