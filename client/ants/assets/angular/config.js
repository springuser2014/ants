
var config = {
	service: {
		page: 'http://localhost:8080/ants/rest/page',
		log: 'http://localhost:8080/ants/rest/log?pageId={pageId}'
	}, 
	directive: {
		main: {
			sideBar: host + '/side-bar.html',
			headerPage: host + '/header-page.html',
			pageBreadcrumbs: host + '/assets/angular/view/ants/page-breadcrumbs.html'
		},
		issuer: {
			layout: host + '/assets/angular/view/page/layout.html',
			table: host + '/assets/angular/view/page/colection.html',

		},
		transaction: {
			layout: host + '/assets/angular/view/log/layout.html',
			table: host + '/assets/angular/view/log/transaction-table.html',
		}
	}
}

