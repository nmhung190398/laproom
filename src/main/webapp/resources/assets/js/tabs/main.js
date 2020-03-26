var listKey = [];
$(".td-data").each(function(index) {
	listKey.push($(this).attr('id'));
})

console.log(listKey);
function loadDataTabs(data,isDel){
	for (const [key, value] of Object.entries(data)){
		let html = `<b>GV:</b> ${value.clasS.teacher.fullname} <br />`;
	      html += `<b>Mã lớp:</b> ${value.clasS.code} <br />`;
	      html += `<b>Môn:</b> ${value.clasS.subject.name} <br />`;
	      if(!value.active && isDel){
	        	html += `<a class="link-active" style="float:right" href="tabs/active/${value.id}">Duyệt</a>`;

	        }else{
	        	$(`#${key}`).attr("style","background-color : #3214");
	        }
	     if(isDel && !value.active){
	    	 html += `<span idDel='${value.id}' class='link-del'><i  class='fa fa-times del-tabs' ></i></span>`;
     	 }
	      $(`#${key}`).html(html);
	}
}


//function loadDataTabs(data,idUser,isRemove) {
//	console.log("===============");
//	console.log(data);
//	if(!isRemove){
//		 $(".td-data").each(function(index) {
//			$(this).html(' ');
//		})
//	 }
//	 for (const [key, value] of Object.entries(data)) {
//
//         let html = `<b>GV:</b> ${value.user.fullname} <br />`;
//         html += `<b>Mã:</b> ${value.subject} <br />`;
//         html += `<b>Lớp:</b> ${value.classes} <br />`;
//         if(value.idUser == idUser){
//        	 $(`#${key}`).attr("style","background-color : #3214");
//        	 if(isRemove && !value.active){
//        		 html += `<span  class='link-del'><i idDel='${value.id}' class='fa fa-times del-tabs' ></i></span>`;
//        	 }
//         }
//         if(!value.active){
//        	 html += `<a class="link-active" style="float:right;display:none" href="tabs/active?id=${value.id}">Duyệt</a>`;
//         }
//
//
//
//
//         $(`#${key}`).html(html);
//         $(`#${key}`).on("click", "i" , function() {
//             console.log($(this));
//             window.location = 'tabs/del?id=' + $(this).attr('idDel');
//         });
//     }
//
//
//}

function dangKy(arrayDate) {
	$('.dang-ky-phong').click(function(index) {
		let shift = $(this).attr('shift');
		let date = arrayDate[$(this).attr('date')];
		$('#shift-modal').val(shift);


		$('#date-modal').val(date);

		let buoi;
		if(shift == 0){
			buoi = 'sáng';
		}else if(shift == 1){
			buoi = 'chiều'
		}else{
			buoi = 'tối'
		}
		$("#title-modal").html(`Buổi ${buoi}, ngày ${date}`);
		$('#modal-dang-ky').modal('show');
	})

		$('#dang-ky').click(function() {
			let form = $('#form-dang-ky');
			console.log(form.serializeArray());
			form.submit();
		})
}


