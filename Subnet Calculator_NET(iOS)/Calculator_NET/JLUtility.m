//
//  JLUtility.m
//  Calculator_NET
//
//  Created by Mark Lewis on 16-3-11.
//  Copyright (c) 2016年 Mark Lewis. All rights reserved.
//

#import "JLUtility.h"
@implementation JLUtility

// format @"11111111"
+ (int)binaryToDec:(NSString *)binaryFormat
{
    int result = 0;
    
    int len = binaryFormat.length;
    for (int i=0; i<len; i++)
    {
        NSString *bitStr = [NSString stringWithFormat:@"%c", [binaryFormat characterAtIndex:i]];
        result += [bitStr intValue]*pow(2, len-1-i);
    }
    return result;
}

// 返回二进制格式的算法，封装为函数
+ (NSString *)printBinary:(int)n
{
    //int temp = sizeof(int) << 3 - 1;
    int temp = (sizeof(int)<<3) - 1;
    NSString *result = @"";
    while (temp >= 0)
    {
        int value = n >> temp & 1;
        result = [NSString stringWithFormat:@"%@%d", result, value];
        
        temp--;
        
        //        if ((temp + 1) % 4 == 0)
        //        {
        //            result = [NSString stringWithFormat:@"%@ ", result];
        //        }
    }
    // result = [NSString stringWithFormat:@"%@\n", result];
    
    
    return result;
}
@end
