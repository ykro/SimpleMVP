package edu.galileo.android.simplemvp.libs.di;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import edu.galileo.android.simplemvp.libs.EventBus;
import edu.galileo.android.simplemvp.libs.GreenRobotEventBus;

/**
 * Created by ykro.
 */
@Module
public class LibsModule {
    
    @Provides
    @Singleton
    EventBus provideEventBus() {
        return new GreenRobotEventBus();
    }
}
