/*
<p class="video-meta" data-video-date="${video.videoDate}">
	조회수 ${video.videoCount}회ㆍ<span class="video-date"></span>
</p>
*/

const videoMeta = document.querySelectorAll('.video-meta');

videoMeta.forEach(meta => {
	let date = meta.getAttribute("data-video-date");
	date = new Date(date);	// Date 형식으로 변환시켜서 가지고 오기
	
	const videoDate = meta.querySelector(".video-date");
	videoDate.innerHTML = getTime(date);
});

function getTime(date) {
	const now = new Date(); // 지금 현재 시간 가져오기
	const diff = Math.floor((now - date) / 1000); // 시간 차이
	
	const rtf = new Intl.RelativeTimeFormat('ko', { numeric: 'auto'}); // 한국 시간으로 가져오기
	
	if(diff < 60) {
		return rtf.format(-diff, 'seconds'); // 초 단위
	} else if(diff < 3600) {
		return rtf.format(-Math.floor(diff / 60), 'minutes'); // 분 단위
	} else if(diff < 86400) {
		return rtf.format(-Math.floor(diff / 3600), 'hours'); // 시간 단위
	} else if(diff < 604800) {
		return rtf.format(-Math.floor(diff / 86400), 'days');
	}
}