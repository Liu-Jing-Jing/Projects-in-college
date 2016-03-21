//
//  MainTableViewController.h
//  Calculator_NET
//
//  Created by Mark Lewis on 16-3-10.
//  Copyright (c) 2016年 Mark Lewis. All rights reserved.
//

#import <UIKit/UIKit.h>

@interface MainTableViewController : UITableViewController<UIPickerViewDelegate, UIPickerViewDataSource>

@property (weak, nonatomic) IBOutlet UIPickerView *pickerView;
@property (weak, nonatomic) IBOutlet UILabel *subnetMaskLabel;
@property (weak, nonatomic) IBOutlet UILabel *netAddressLabel;
@property (weak, nonatomic) IBOutlet UILabel *broadcastLabel;
@property (weak, nonatomic) IBOutlet UILabel *addressLabel;
@property (weak, nonatomic) IBOutlet UILabel *addressBinaryLabel;
@end
