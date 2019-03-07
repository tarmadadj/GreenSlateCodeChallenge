let apiBase='/api/users/'
function getAllUsers(model){
	
	axios
	.get(apiBase)
	.then(response => (model.users = response.data))
}

function getAllProjectsForUser(model, userId){
	let request=apiBase+userId+'/projects/'
	axios
	.get(request)
	.then(response => (model.projects = response.data))
	
}