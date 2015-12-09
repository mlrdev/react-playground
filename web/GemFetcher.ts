/**
 * Created by mrothe on 08.12.15.
 */


module Store {
    export class GemFetcher {
        /**
         *
         * @param uri
         * @param isAsync
         * @param user
         * @param password
         */
        constructor(private uri:string, private isAsync:boolean, private user:string, private password:string) {
        }

        render(documentId:string) {
            var url = this.uri + '?enable_cors_headers=true&enable_http_auth=true'
            var xhr = new XMLHttpRequest()
            xhr.onreadystatechange = function () {
                if (xhr.readyState === 4 && xhr.status === 200) {
                    document.getElementById(documentId).innerHTML = JSON.parse(xhr.responseText)
                } else {
                    document.getElementById(documentId).innerHTML = "it has not worked... :-/"
                }
            }

            xhr.open('GET', url, this.isAsync, this.user, this.password)
            xhr.onload = function () {
                console.log("Response:" + this.responseText)
            }
            xhr.withCredentials = true
            xhr.setRequestHeader('Accept', 'application/json')
            xhr.setRequestHeader('Access-Control-Allow-Origin', 'http://localhost')
            xhr.send()
        }
    }
}

import GemFetcher = Store.GemFetcher
window.onload = () => {
    var gemFetcher = new GemFetcher('http://localhost:8080/gems', true, 'user', 'password')
    gemFetcher.render('gems')
}