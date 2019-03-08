/*
 * vueApp() function is called once all the related js libraries are loaded so it can build the Vue Application
 * Vue is a powerful MVVM implementation which can be used for Single Page Aplications. In this case i used two components:
 * 1. a an app main component which represents the life cycle of this application, including the model (data, these properties are binded to the view), 
 * method calls (methods property), and state of the life cycle of the application (mounted property which calls to get the users in this example)
 * 2. a separated component which handles the Project rows showed once a end user selects which projects user are to be shown
 */
function vueApp(){
	/*
	 * This calls the function which declares the filters to be used in order to format the project data in the desired fashion
	 */
	vueFilters()
	/*
	 *This component represents the data of each row and it has a template used to render the table 
	 */
	Vue.component('project-row', {
	  /* options */
		props:['row'],
		template: `<tr><td>{{row.project.id}}</td>
			<td>{{row.project.startDate | format-date }}</td>
			<td>{{row.project.startDate | date-diff(row.assignedDate) }}</td>
			<td>{{row.project.endDate | format-date}}</td>
			<td>{{row.project.credits}}</td>
			<td>{{row.isActive | active-filter}}</td></tr>`
	})
	/*
	 * This an isntance of the application and it represents the functionality that is required
	 * It has:
	 * 	Databinded model which is used to feed the templates, if these variables change, the views
	 * 	are binded to them which means they also change in real time. 
	 *  A call to get users in order to fill the select control once the application is ready to use
	 *  A method callback which gets all the projects for the selected user
	 *  
	 */
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