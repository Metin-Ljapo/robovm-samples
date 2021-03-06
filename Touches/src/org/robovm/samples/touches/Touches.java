/*
 * Copyright (C) 2014 Trillian Mobile AB
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 *   
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License. 
 * 
 * Portions of this code is based on Apple Inc's Touches sample (v2.0)
 * which is copyright (C) 2008-2013 Apple Inc.
 */

package org.robovm.samples.touches;

import org.robovm.apple.foundation.NSAutoreleasePool;
import org.robovm.apple.uikit.UIApplication;
import org.robovm.apple.uikit.UIApplicationDelegateAdapter;
import org.robovm.apple.uikit.UIApplicationLaunchOptions;
import org.robovm.apple.uikit.UIScreen;
import org.robovm.apple.uikit.UITabBarController;
import org.robovm.apple.uikit.UIWindow;
import org.robovm.samples.touches.viewcontrollers.GestureViewController;
import org.robovm.samples.touches.viewcontrollers.TouchViewController;

public class Touches extends UIApplicationDelegateAdapter {
    private UIWindow window;
    private UITabBarController rootViewController;
    private TouchViewController touchViewController;
    private GestureViewController gestureViewController;

    @Override
    public boolean didFinishLaunching (UIApplication application, UIApplicationLaunchOptions launchOptions) {
        // Set up the view controller.
        rootViewController = new UITabBarController();

        touchViewController = new TouchViewController();
        rootViewController.addChildViewController(touchViewController);
        gestureViewController = new GestureViewController();
        rootViewController.addChildViewController(gestureViewController);

        // Create a new window at screen size.
        window = new UIWindow(UIScreen.getMainScreen().getBounds());
        // Set our viewcontroller as the root controller for the window.
        window.setRootViewController(rootViewController);
        // Make the window visible.
        window.makeKeyAndVisible();

        /*
         * Retains the window object until the application is deallocated. Prevents Java GC from collecting the window object too
         * early.
         */
        addStrongRef(window);

        return true;
    }

    public static void main (String[] args) {
        NSAutoreleasePool pool = new NSAutoreleasePool();
        UIApplication.main(args, null, Touches.class);
        pool.close();
    }
}
