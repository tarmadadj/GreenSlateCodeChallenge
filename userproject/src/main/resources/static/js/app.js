function vueApp(){
	vueFilters()
	var app =new Vue({
		el: '#app',
		data () {
			return {
				users:null,
				selected:'0',
				projects:null
			}
		},
		
		mounted () {
			getAllUsers(this)
		},
		methods: {
			onChange(event) {
				getAllProjectsForUser(this, event.target.value)
			}
		}

	}) 
}