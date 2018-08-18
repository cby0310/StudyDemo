package com.cyb.test.mytest.robo;

import org.junit.runners.model.InitializationError;
import org.robolectric.RoboSettings;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.internal.ManifestFactory;
import org.robolectric.internal.ManifestIdentifier;
import org.robolectric.manifest.AndroidManifest;
import org.robolectric.res.Fs;

/**
 * Created by chaoyongbing on 2017/11/1 16:20.
 */

public class MyRoboTestRunner extends RobolectricTestRunner {
    /**
     * Creates a runner to run {@code testClass}. Looks in your working directory for your AndroidManifest.xml file
     * and res directory by default. Use the {@link Config} annotation to configure.
     *
     * @param testClass the test class to be run
     * @throws InitializationError if junit says so
     */
    public MyRoboTestRunner(Class<?> testClass) throws InitializationError {
        super(testClass);

        // 从源码知道MavenDependencyResolver默认以RoboSettings的repositoryUrl和repositoryId为默认值，因此只需要对RoboSetting进行赋值即可
        RoboSettings.setMavenRepositoryId("alimaven");
        RoboSettings.setMavenRepositoryUrl("http://maven.aliyun.com/nexus/content/groups/public/");
    }

    private static final String BUILD_OUTPUT = "D:/CYB/AndroidStudio/workspace/github/StudyDemo/app/build" +
            "/intermediates/";

    @Override
    protected AndroidManifest getAppManifest(Config config) {
        String manifestPath = BUILD_OUTPUT + "manifests/full/xiaomi/debug/AndroidManifest.xml";
        String resDir = BUILD_OUTPUT + "res/merged/debug";
        String assetsDir = BUILD_OUTPUT + "assets/debug";


        ManifestIdentifier identifier = new ManifestIdentifier(Fs.fileFromPath(manifestPath),
                Fs.fileFromPath(resDir),
                Fs.fileFromPath(assetsDir), "com.heyzhima.yw", null);

        ManifestFactory manifestFactory = getManifestFactory(config);
        AndroidManifest appManifest = manifestFactory.create(identifier);

        return appManifest;

//        ManifestFactory manifestFactory = getManifestFactory(config);
//        ManifestIdentifier identifier = manifestFactory.identify(config);
//
//        synchronized (appManifestsCache) {
//            AndroidManifest appManifest;
//            appManifest = appManifestsCache.get(identifier);
//            if (appManifest == null) {
//                appManifest = manifestFactory.create(identifier);
//                appManifestsCache.put(identifier, appManifest);
//            }
//
//            return appManifest;
//        }
    }


}
