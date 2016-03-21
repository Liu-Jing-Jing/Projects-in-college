//
//  JLUtility.h
//  Calculator_NET
//
//  Created by Mark Lewis on 16-3-11.
//  Copyright (c) 2016年 Mark Lewis. All rights reserved.
//

#import <Foundation/Foundation.h>
#include <math.h>
@interface JLUtility : NSObject

+ (NSString *)printBinary:(int)n;
+ (int)binaryToDec:(NSString *)binaryFormat;
@end
