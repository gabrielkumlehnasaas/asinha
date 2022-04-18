var mask = {
    cpfMask(value) {
    return value
        .replace(/\D/g, "")
        .replace(/(\d{3})(\d)/, "$1.$2")
        .replace(/(\d{3})(\d)/, "$1.$2")
        .replace(/(\d{3})(\d{1,2})/, "$1-$2" )
    },

    cnpjMask(value) {
        return value
        .replace(/\D/g, "")
        .replace(/(\d{2})(\d)/, "$1.$2")
        .replace(/(\d{3})(\d)/, "$1.$2")
        .replace(/(\d{3})(\d)/, "$1/$2")
        .replace(/(\d{4})(\d)/, "$1-$2")
    },

    telefoneMask(value) {
        return value
        .replace(/\D/g, "")
        .replace(/(\d{2})(\d)/, "($1).$2")
        .replace(/(\d{4})(\d)/, "$1-$2")
        .replace(/(\d{4})-(\d)(\d{4})/, "$1$2-$3")
    },

    cepMask(value){
        return value
        .replace(/\D/g, "")
        .replace(/(\d{5})(\d)/, "$1-$2")
    }
    
}  

document.querySelectorAll("input").forEach(($input) => {
var field = $input.dataset.js

$input.addEventListener("input", (e) => {
    e.target.value = mask[field](e.target.value)
    }, false)
});
