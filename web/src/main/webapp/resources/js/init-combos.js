// эта функция принимает на вход ID HTML элемента и JSON массив данных.
// она вставялет новые опции для селекта в текущий компонент. здесь она лишь объявляется (как метод в классе) - вызываться она будет позже
function initSelectElement(htmlElementId, jsonArray) {
    $('#' + htmlElementId).find('option').remove().end(); // удалить все
    // старые опции

    // вставить пустую опцию. в случае edit формы при начальной загрузке надо
    // будет подправить код, чтобы не перетиралоась выбранная опция. текущий
    // вариант только для нового объекта
    $('#' + htmlElementId).append($("<option></option>").attr({
        "disabled" : '',
        "selected" : '',
        "value" : ''
    }).text(' -- select an option -- '));

    // вставляет новые опции в элемент
    $.each(jsonArray, function(key, value) {
        $('#' + htmlElementId).append($("<option></option>").attr("value", value.id).text(value.name));
    });
}

function initComboboxes(contextUrl) {

    $.get(contextUrl + "/location/regions", function(regionsArray) {

        initSelectElement('regionId', regionsArray);

        $("#regionId").change(function() {
            resetSelectElement('countryId')
            resetSelectElement('cityId')

            var selectedId = $(this).val();
            $.get(contextUrl + "/location/countries?regionId=" + selectedId, function(countriesArray) {
                initSelectElement('countryId', countriesArray);
            })
        });

        $("#countryId").change(function() {
            resetSelectElement('cityId')
            var selectedId = $(this).val();
            $.get(contextUrl + "/location/cities?countryId=" + selectedId, function(citiesArray) {
                initSelectElement('cityId', citiesArray);
            })

        });
    });

}


function resetSelectElement(id){

    $('#'+id).prop('selectedIndex',0);
}