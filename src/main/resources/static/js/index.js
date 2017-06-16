/**
 * Created by 1004w455 on 2017. 6. 16..
 */

String.prototype.format = function () {
    var args = [].slice.call(arguments, 0), i = 0;
    return this.replace(/%s/g, function () {
        return args[i++];
    });
};

$.ajax({
    url: '/api/info',
    dataType: 'json',
    success: function (data) {
        draw(data);
    }
});

function draw(data) {
    $('#app').html([
        '<ul>',
        (function () {
            return data
                .sort(function (a, b) {
                    if (a.name > b.name) return 1;
                    return -1;
                })
                .map(function (d) {
                    healthChecker(d.id, d.url);
                    return '<li>%s: <a href="%s" target="_blank">%s</a>(<span id="id_%s"></span>)</li>'
                        .format(d.name, d.url, d.url, d.id);
                }).join('');
        }()),
        '</ul>'
    ].join(''));
}

function healthChecker(id, url) {
    $.ajax({
        url: '/healthcheck',
        data: {url: url},
        dataType: 'text',
        success: function (status) {
            $('#id_' + id)
                .text(status)
                .css({backgroundColor: status === 'Red' ? 'red' : 'green'});
        }
    })
}
