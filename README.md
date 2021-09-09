Table of Contents
I. Chức năng	4
I.1 Màn Hình Login	4
I.2 Màn Hình Home	4
I.3 Màn Hình thể loại	4
I.4 Màn Hình map	4
I.5 Màn Hình Search	4
I.6 Màn Hình Favorite	4
I.7 Màn Hình Profile	5
II Mô tả chức năng	5
II.1 Màn hình login	5
II.1.1 Đăng nhập	5
II.1.2 Đăng ký	5
II.1.3 Quên mật khẩu	6
II.2 Màn hình home	6
II.2.1 Hiển thị slide ảnh	6
II.2.2 Hiển thị menu các loại điệm điểm du lịch	7
II.2.3 Hiển thị danh sách các địa điểm theo từng loại	7
II.2.4 Bottom Menu	8
II.3 Màn hình search	8
II.3.1 Tìm kiếm địa điểm du lịch theo tên	8
II.4 Màn Hình Favorite	9
II.4.1 Hiển thị danh sách các địa điểm du lịch yêu thích	9
II.4.2 Tìm kiếm địa điểm du lịch yêu thích theo tên	9
II.5 Màn hình Profile	10
II.5.1 Xem thông tin cá nhân	10
II.5.2 Cập nhật thông tin cá nhân	10
II.5.3 Xem thông tin giới thiệu về ứng dụng	11
II.6 Màn hình thể loại	11
II.6.1 Hiển thị danh sách các địa điểm du lịch theo thể loại	11
II.6.2 Xem chi tiết địa điểm du lịch	12
II.6.3 Tìm kiếm địa điểm du lịch theo tên	12
II.7 Màn hình map	13
II.7.1 Hiển thị địa điểm du lịch trên bản đồ	13


















I. Chức năng 
I.1 Màn Hình Login 
stt
Chức Năng
1
Đăng nhập
2
Đăng ký
3
Quên mật khẩu


I.2 Màn Hình Home
STT
Chức Năng
1
Hiển thị slide ảnh
2
Hiển thị menu (phân chia địa điểm du lịch theo từng loại)
3
Hiển thị danh sách các địa điểm du lịch theo từng loại
4
Bottom menu 


I.3 Màn Hình thể loại
stt
Chức Năng
1
Hiển thị danh sách các địa điểm du lịch theo thể loại
2
Xem chi tiết địa điểm du lịch
3
Tìm kiềm địa điểm du lịch theo tên


I.4 Màn Hình map
stt
Chức Năng
1
Hiển thị địa điểm du lịch trên bản đồ


I.5 Màn Hình Search
STT
Chức Năng
1
Tìm kiếm địa điểm du lịch theo tên


I.6 Màn Hình Favorite
STT
Chức Năng
1
Hiển thị các địa điểm du lịch yêu thích
2
Tìm kiếm địa điểm du lịch yêu thích theo tên


I.7 Màn Hình Profile
STT
Chức Năng
1
Xem thông tin cá nhân
2
Cập nhật thông tin cá nhân
3
Xem thông tin giới thiệu về ứng dụng







II Mô tả chức năng
II.1 Màn hình login
II.1.1 Đăng nhập
Requirement ID
DN21_FR_AND_LG
SRS_ID
DN21_FR_AND_LG_001
Description
Given/ Điều kiện tiền đề
App run
Hiển thị màn hình login
When/ Điều kiện kích hoạt
Người dùng điền tài khoản email và mật khẩu
Nhấn vào button login
Then/ Kết quả
True : Thông báo login thành công, chuyển qua màn hình home 
False: Thông báo login thất bại, ở lại màn hình login
Input Data
Email và mật khẩu
Output Data
Hiển thị thông báo thành công hoặc thất bại
References




II.1.2 Đăng ký
Requirement ID
DN21_FR_AND_LG
SRS_ID
DN21_FR_AND_LG_002
Description
Given/ Điều kiện tiền đề
App run
Click vào register ở màn hình login để chuyển qua màn hình đăng ký
When/ Điều kiện kích hoạt
Người dùng nhập tên, email, mật khẩu
Nhấn vào button register
Then/ Kết quả
True : Thông báo đăng ký thành công, chuyển qua màn hình login
False: Thông báo đăng ký  thất bại, kiểm tra lại thông tin đăng ký, không chuyển màn hình
Input Data
Tên, email, mật khẩu
Output Data
Hiển thị thông báo đăng ký thành công hay thất bại
References




II.1.3 Quên mật khẩu
Requirement ID
DN21_FR_AND_LG
SRS_ID
DN21_FR_AND_LG_003
Description
Given/ Điều kiện tiền đề
App run
Chọn vào quên mật khẩu ở màn hình login để chuyển qua màn hình quên mật khẩu
When/ Điều kiện kích hoạt
Người dùng nhập email – chuyển qua màn hình nhập code 
Nhập code được gửi về từ email
Then/ Kết quả
True : Hiển thị mật khẩu cho người dùng 
False: Thông báo thất bại, yêu cầu kiểm tra lại code
Input Data
Code
Output Data
Mật khẩu
References




II.2 Màn hình home
II.2.1 Hiển thị slide ảnh
Requirement ID
DN21_FR_AND_HOME
SRS_ID
DN21_FR_AND_HOME_01
Description
Given/ Điều kiện tiền đề
Login thành công
App run
When/ Điều kiện kích hoạt


Then/ Kết quả
Hiển thị slide ảnh ở phía trên cùng màn hình home
Tự động chuyển đổi qua lại giữa các slide
Input Data


Output Data
Hiển thị slide ảnh
References




II.2.2 Hiển thị menu các loại điệm điểm du lịch
Requirement ID
DN21_FR_AND_HOME
SRS_ID
DN21_FR_AND_HOME_02
Description
Given/ Điều kiện tiền đề
App run
Login thành công
When/ Điều kiện kích hoạt


Then/ Kết quả
Menu hiển thị các loại địa điểm du lịch
Có thể vuốt ngang để xem danh sách
Input Data


Output Data
Hiển thị menu các loại địa điểm du lịch
References




II.2.3 Hiển thị danh sách các địa điểm theo từng loại
Requirement ID
DN21_FR_AND_HOME
SRS_ID
DN21_FR_AND_HOME_03
Description
Given/ Điều kiện tiền đề
App run
Login thành công
When/ Điều kiện kích hoạt


Then/ Kết quả
Hiển thị danh sách các địa điểm du lịch theo từng loại tương ứng phần menu
Có thể vuốt ngang để xem các địa điểm du lịch
Input Data


Output Data
Hiển thị dữ liệu danh sách các địa điểm du lịch
References




II.2.4 Bottom Menu
Requirement ID
DN21_FR_AND_HOME
SRS_ID
DN21_FR_AND_HOME_04
Description
Given/ Điều kiện tiền đề
App run
Login thành công
When/ Điều kiện kích hoạt


Then/ Kết quả
Hiển thị thanh bottom menu  ở cuối màn hình
Gồm có 4 nút điều hướng (home, search, fovorite, profile)
Click vào các nút sẽ chuyển sang màn hình tương ứng
Input Data


Output Data
Hiển thị thanh bottom menu
References




II.3 Màn hình search
II.3.1 Tìm kiếm địa điểm du lịch theo tên
Requirement ID
DN21_FR_AND_SEARCH
SRS_ID
DN21_FR_AND_SEARCH_01
Description
Given/ Điều kiện tiền đề
App run
Nhấn vào icon search ở bottom menu
When/ Điều kiện kích hoạt
Nhập tên địa đểm du lịch
Then/ Kết quả
Hiển thị danh sách các địa điểm khớp với tên vừa nhập
Input Data
Tên địa điểm du lịch
Output Data
Trả về danh sách các địa điểm du lịch tương ứng
References




II.4 Màn Hình Favorite
II.4.1 Hiển thị danh sách các địa điểm du lịch yêu thích
Requirement ID
DN21_FR_AND_FAVORITE
SRS_ID
DN21_FR_AND_FAVORITE_01
Description
Given/ Điều kiện tiền đề
App run
Nhấn vào icon favorite ở bottom menu
When/ Điều kiện kích hoạt


Then/ Kết quả
Hiển thị danh sách các địa điểm du lịch yêu thích
Input Data


Output Data
Hiển thị danh sách các địa điểm du lịch yêu thích
References




II.4.2 Tìm kiếm địa điểm du lịch yêu thích theo tên
Requirement ID
DN21_FR_AND_FAVORITE
SRS_ID
DN21_FR_AND_FAVORITE_01
Description
Given/ Điều kiện tiền đề
App run
Nhấn vào icon favorite ở bottom menu
When/ Điều kiện kích hoạt
Nhập tên địa điểm du lịch
Then/ Kết quả
Hiển thị danh sách các địa điểm khớp với tên vừa nhập
Input Data


Output Data
Trả về danh sách các địa điểm du lịch tương ứng
References





II.5 Màn hình Profile
II.5.1 Xem thông tin cá nhân
Requirement ID
DN21_FR_AND_PROFILE
SRS_ID
DN21_FR_AND_PROFILE_01
Description
Given/ Điều kiện tiền đề
App run
Nhấn vào icon profile, chọn vào mục my profile ở màn hình profile
When/ Điều kiện kích hoạt


Then/ Kết quả
Hiển thị thông tin cá nhân bao gồm email, tên, giới tính, ngày sinh, số điện thoại
Input Data


Output Data
Trả về thông tin cá nhân
References




II.5.2 Cập nhật thông tin cá nhân
Requirement ID
DN21_FR_AND_PROFILE
SRS_ID
DN21_FR_AND_PROFILE_03
Description
Given/ Điều kiện tiền đề
App run
Nhấn vào icon profile, chọn vào mục my profile ở màn hình profile
When/ Điều kiện kích hoạt
Nhập thông tin về giới tính, ngày sinh, số điện thoại
Nhấn vào update
Then/ Kết quả
Đúng định dạng – thông báo thành công và cập nhật thông tin người dùng
Sai định dạng – thông báo thất bại và yêu cầu nhập lại
Input Data
Giới tính, ngày sinh, số điện thoại
Output Data
Thông báo thành công và thay đổi thông tin tài khoản
References





II.5.3 Xem thông tin giới thiệu về ứng dụng
Requirement ID
DN21_FR_AND_PROFILE
SRS_ID
DN21_FR_AND_PROFILE_03
Description
Given/ Điều kiện tiền đề
App run
Nhấn vào icon profile, chọn vào mục about ở màn hình profile
When/ Điều kiện kích hoạt


Then/ Kết quả
Hiển thị thông tin về ứng dụng: website, fanpage..
Input Data


Output Data
Trả về thông tin ứng dụng
References




II.6 Màn hình thể loại
II.6.1 Hiển thị danh sách các địa điểm du lịch theo thể loại
Requirement ID
DN21_FR_AND_CATEGORY
SRS_ID
DN21_FR_AND_CATEGORY_01
Description
Given/ Điều kiện tiền đề
App run
Nhấn vào các thể loại ở màn hình home
Nhấn vào các icon ở menu thể loại
When/ Điều kiện kích hoạt


Then/ Kết quả
Hiển thị danh sách các địa điểm du lịch theo thể loại
Input Data


Output Data
Hiển thị danh sách các địa điểm du lịch theo thể loại
References




II.6.2 Xem chi tiết địa điểm du lịch
Requirement ID
DN21_FR_AND_ CATEGORY
SRS_ID
DN21_FR_AND_ CATEGORY _02
Description
Given/ Điều kiện tiền đề
App run
Nhấn vào item địa điểm du lịch ở mà hình thể loại hoặc màn hình home
When/ Điều kiện kích hoạt


Then/ Kết quả
Hiển thị màn hình chi tiết địa điểm du lịch: hình ảnh, giới thiệu, mô tả chi tiết, địa chỉ
Input Data


Output Data
Trả về màn hình chi tiết địa điểm du lịch
References




II.6.3 Tìm kiếm địa điểm du lịch theo tên
Requirement ID
DN21_FR_AND_ CATEGORY
SRS_ID
DN21_FR_AND_ CATEGORY _03
Description
Given/ Điều kiện tiền đề
App run
Nhấn vào các thể loại ở màn hình home
Nhấn vào các icon ở menu thể loại
When/ Điều kiện kích hoạt
Nhập tên địa đểm du lịch vào thanh tìm kiếm
Then/ Kết quả
Hiển thị danh sách điểm du lịch theo tên
Input Data


Output Data
Trả về danh sách địa điểm du lịch theo tên
References





II.7 Màn hình map
II.7.1 Hiển thị địa điểm du lịch trên bản đồ
Requirement ID
DN21_FR_AND_ MAP
SRS_ID
DN21_FR_AND_ MAP _03
Description
Given/ Điều kiện tiền đề
App run
Nhấn vào map ở màn hình chi tiết địa điểm du lịch
When/ Điều kiện kích hoạt


Then/ Kết quả
Hiển thị địa điểm du lịch trên bản đồ
Input Data


Output Data
Hiển thị địa điểm du lịch trên bản đồ
References




