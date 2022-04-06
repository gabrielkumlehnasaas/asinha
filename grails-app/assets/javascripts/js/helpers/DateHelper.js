class DateHelper {
    
    constructor() {
        throw new Error('Esta classe não pode ser instanciada');
    }
    
    static dataParaTexto(data) {
        return `${data.getDate()}/${data.getMonth()+1}/${data.getFullYear()}`;
    }
}