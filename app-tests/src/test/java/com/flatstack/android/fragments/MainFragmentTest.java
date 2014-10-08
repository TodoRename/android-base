package com.flatstack.android.fragments;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.flatstack.android.R;
import com.flatstack.android.RobolectricGradleTestRunner;
import com.flatstack.android.dagger.Dagger;
import com.flatstack.android.dagger.ScopedContextWrapper;
import dagger.Module;
import dagger.ObjectGraph;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(RobolectricGradleTestRunner.class)
public class MainFragmentTest {
  @Test public void testInjectorContextWrapper() {
    Robolectric.buildActivity(Activity.class).create().get();
    ObjectGraph objectGraph = Dagger.getObjectGraph(Robolectric.application).plus(new MyModule());
    Context context = new ScopedContextWrapper(Robolectric.application, objectGraph);
    LayoutInflater inflater = LayoutInflater.from(context);
    View view = inflater.inflate(R.layout.main, new FrameLayout(context));
    assertThat(Dagger.getObjectGraph(view.getContext())).isEqualTo(objectGraph);
  }

  @Module static class MyModule {
  }
}