//
//  main.m
//  Demo1
//
//  Created by Dmitriy Korobskiy on 5/23/10.
//  Copyright NETE 2010. All rights reserved.
//

#import <Cocoa/Cocoa.h>
#import <AppleScriptObjC/AppleScriptObjC.h>

int main(int argc, char *argv[])
{
	[[NSBundle mainBundle] loadAppleScriptObjectiveCScripts];

	return NSApplicationMain(argc, (const char **) argv);
}
