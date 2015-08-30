package org.mycompany

class SearchController {

    def elasticSearchService

    def search = {
        // query: firstName:”fname1”
        def res = elasticSearchService.search("${params.query}")
        def haveResults = true
        [query:params.query, total:res.total, searchResults:res.searchResults, haveResults:haveResults]
    }

}
