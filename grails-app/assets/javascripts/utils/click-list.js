$(document).ready(function() {
    $("tr").on("click", function() {
        window.location.href = $(this).data("url")
    })
})
