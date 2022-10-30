var IMP = window.IMP;
IMP.init("imp67338724");
  
var today = new Date();
var hours = today.getHours(); 
var minutes = today.getMinutes();
var seconds = today.getSeconds();
var milliseconds = today.getMilliseconds();
var makeMerchantUid = hours +  minutes + seconds + milliseconds;

function requestPay(name, price) {
    IMP.request_pay({
    pg : 'kakaopay',
    merchant_uid: "IMP"+makeMerchantUid,
    name : name,
    amount : price,
    buyer_email : 'asdoe22@gamil.com',
    buyer_name : 'history',
    buyer_tel : '010-1234-5678',
    buyer_addr : '서울특별시 강남구 삼성동', 
    buyer_postcode : '123-456',
    }, function (rsp) {
        if (rsp.success) {
            console.log(rsp);
            var msg = '결제가 완료되었습니다.\n';
             msg += '고유ID : ' + rsp.imp_uid+"\n";
             msg += '상점 거래ID : ' + rsp.merchant_uid+"\n";
             msg += '결제 금액 : ' + rsp.paid_amount+'원\n';
             msg += '카드 승인번호 : ' + rsp.apply_num;
             
             getReserve.submit();
        } else {
            console.log(rsp);
            var msg = '결제에 실패하였습니다.\n';
            msg += '에러내용 : ' + rsp.error_msg;
        }
       alert(msg);
    });
}