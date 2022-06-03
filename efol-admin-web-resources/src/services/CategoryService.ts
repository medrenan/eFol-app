import requester from "./Requester"

class CategoryService {

    static BASE_URL = "http://localhost:8080/folCategory"


    findAll(){
        return requester.get(`${CategoryService.BASE_URL}/findAll`)
    }

    create(category: any){
        return requester.post(`${CategoryService.BASE_URL}/create`, category)
    }
}

const categoryService = new CategoryService();
export default categoryService;