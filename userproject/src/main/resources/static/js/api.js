/*
 * These functions handle I/O operations with the backend server
 * They all work around the /api/users/ path so if the application were to be expanded we could add one api for each
 * page or entity
 */
let apiBase='/api/users/';
/*
 * Uses Axios in order to communicate with the backend, Axios is a Powerful and lightweight library which handles
 * AJAX Http requests, similar to Jquery in that fashion but it doesn't have the DOM manipulation methods that in this case are handled
 * by Vue.JS, it also supports promises in order to create a real asynchronous experience.
 * This function also receives a model which in this case is used by Vue JS to perform its binding operations
 */
function getAllUsers(model){
	
	axios
	.get(apiBase)
	.then(response => (model.users = response.data))
}
/*
 * In a Similar fashion this requests for UserProject objects using Axios to perform a HTTP Request, once the model is updated
 * Vue updates the table view in order to match the new data.
 */
function getAllProjectsForUser(model, userId){
	let request=apiBase+userId+'/projects/'
	axios
	.get(request)
	.then(response => (model.projects = response.data))
	
}