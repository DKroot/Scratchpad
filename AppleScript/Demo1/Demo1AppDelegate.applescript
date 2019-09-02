--
--  Demo1AppDelegate.applescript
--  Demo1
--
--  Created by Dmitriy Korobskiy on 5/23/10.
--  Copyright 2010 NETE. All rights reserved.
--

script Demo1AppDelegate
	property parent : class "NSObject"
	
	on applicationWillFinishLaunching_(aNotification)
		-- Insert code here to initialize your application before any files are opened 
	end applicationWillFinishLaunching_
	
	on applicationShouldTerminate_(sender)
		-- Insert code here to do any housekeeping before your application quits 
		return current application's NSTerminateNow
	end applicationShouldTerminate_
	
end script