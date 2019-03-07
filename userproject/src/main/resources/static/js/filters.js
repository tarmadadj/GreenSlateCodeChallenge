function vueFilters(){
	
	Vue.filter('format-date', function (value) {
		if (!value) return ''
		let dateMomment = moment(value)
		return dateMomment.format('MMMM Do YYYY'); // March 6th 2019, 11:56:30 pm
	})
	Vue.filter('date-diff', function (value, otherDate) {
		if (!value) return ''
		var one_day=1000*60*60*24;
		let date1=new Date(value);
		let date2=new Date(otherDate);
		  // Convert both dates to milliseconds
		let date1_ms = date1.getTime();
		let date2_ms = date2.getTime();
		
		// Calculate the difference in milliseconds
		let difference_ms = date1_ms - date2_ms;
			
		// Convert back to days and return
		let daysToStart =  Math.round(difference_ms/one_day); 
		
		if (daysToStart>0) return daysToStart
		else return 'Started'
	})
	Vue.filter('active-filter', function (value) {
		if (value) return 'Active'
		else  return 'Inactive'
		})
	
    		
}