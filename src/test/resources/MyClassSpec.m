#import <Specta/Specta.h>
#import <Specta/Expecta.h>

#import "MyClass.h"

@interface MyClass (Spec)
@end

SpecBegin(MyClass)

    __block MyClass *subject;

    before(^{
        subject = [[MyClass alloc] init];
    });

    describe(@"", ^{
    });

SpecEnd
