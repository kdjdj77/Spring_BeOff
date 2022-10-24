let test = [];
let selectedSeats = new Array();
let selectedSeatsMap = [];
const seatWrapper = document.querySelector(".seat-wrapper");
let clicked = "";
let div = "";
const rows = 15;
const cols = 10;

for (let i = 0; i < rows; i++) {
    div = document.createElement("div");
    seatWrapper.append(div);
    for (let j = 1; j < cols; j++) {
		if (j == 4 || j == 7) { // 빈 열
			const input = document.createElement('input');
	        input.type = "button";
	        input.classList = "seat inv";
	        mapping(input, i, j);
	        div.append(input);
		}
		if (reserved.includes(returnSeat(i, j))) {
			const input = document.createElement('input');
	        input.type = "button";
	        input.classList = "seat none";
	        mapping(input, i, j);
	        div.append(input);
		} else {
	        const input = document.createElement('input');
	        input.type = "button";
	        input.name = "seats"
	        input.classList = "seat";
	        mapping(input, i, j);
	        div.append(input);
	        input.addEventListener('click', function(e) {
	            console.log(e.target.value);
	            //중복방지 함수
	            selectedSeats = selectedSeats.filter((element, index) => selectedSeats.indexOf(element) != index);
				//click class가 존재할때 제거
				if (input.classList.contains("clicked")) {
	                input.classList.remove("clicked");
	                clicked = document.querySelectorAll(".clicked");
	                selectedSeats.splice(selectedSeats.indexOf(e.target.value), 1);
	                clicked.forEach((data) => {selectedSeats.push(data.value);});
	            }
            	//click class가 존재하지 않을때 추가
	            else {
	                input.classList.add("clicked");
	                clicked = document.querySelectorAll(".clicked");
	                clicked.forEach((data) => {selectedSeats.push(data.value);});
	            }
	            console.log(selectedSeats);
	        })
		}
    }
}
function returnSeat(i, j) {
	if 		(i === 0)return "A0" + j;
	else if (i === 1)return "B0" + j;
	else if (i === 2)return "C0" + j;
	else if (i === 3)return "D0" + j;
	else if (i === 4)return "E0" + j;
	else if (i === 5)return "F0" + j;
	else if (i === 6)return "G0" + j;
	else if (i === 7)return "H0" + j;
	else if (i === 8)return "I0" + j;
	else if (i === 9)return "J0" + j;
	else if (i === 10)return "K0" + j;
	else if (i === 11)return "L0" + j;
	else if (i === 12)return "M0" + j;
	else if (i === 13)return "N0" + j;
	else if (i === 14)return "O0" + j;	
}

function mapping(input, i, j) {
    if (i === 0) {input.value = "A0" + j;} 
    else if (i === 1) {input.value = "B0" + j;}
    else if (i === 2) {input.value = "C0" + j;}
    else if (i === 3) {input.value = "D0" + j;}
    else if (i === 4) {input.value = "E0" + j;}
    else if (i === 5) {input.value = "F0" + j;}
    else if (i === 6) {input.value = "G0" + j;}
    else if (i === 7) {input.value = "H0" + j;}
    else if (i === 8) {input.value = "I0" + j;}
    else if (i === 9) {input.value = "J0" + j;}
    else if (i === 10) {input.value = "K0" + j;}
    else if (i === 11) {input.value = "L0" + j;}
    else if (i === 12) {input.value = "M0" + j;}
    else if (i === 13) {input.value = "N0" + j;}
    else if (i === 14) {input.value = "O0" + j;}
}