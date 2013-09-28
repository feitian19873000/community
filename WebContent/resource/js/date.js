$(document).ready(function() {
	var day=['星期天','星期一','星期二','星期三','星期四','星期五','星期六'];
	SetData();
	function SetData() {
		var now = new Date();
	    //星期
	    $('.top_date').html(day[now.getDay()]+'&nbsp;');
	    //年
	    $('.top_date').append(now.getFullYear());
	    //月
	    month=now.getMonth();
	    if(month<10) {month='0'+month};
	    $('.top_date').append('-'+month);
	    //日
	    date=now.getDate();
	    if(date<10) {date='0'+date};
	    $('.top_date').append('-'+date+'&nbsp;');
	    hour=now.getHours();
	    minutes=now.getMinutes();
	    if (minutes<10) {minutes='0'+minutes};
	    $('.top_date').append(hour+':'+minutes);
	}
    //每个60秒重新刷新日期
    setInterval(SetData,60);
});
