/* To avoid CSS expressions while still supporting IE 7 and IE 6, use this script */
/* The script tag referencing this file must be placed before the ending body tag. */

/* Use conditional comments in order to target IE 7 and older:
	<!--[if lt IE 8]><!-->
	<script src="ie7/ie7.js"></script>
	<!--<![endif]-->
*/

(function() {
	function addIcon(el, entity) {
		var html = el.innerHTML;
		el.innerHTML = '<span style="font-family: \'tpicon\'">' + entity + '</span>' + html;
	}
	var icons = {
		'tps-ac': '&#xe900;',
		'tps-airport': '&#xe901;',
		'tps-amenity': '&#xe902;',
		'tps-bar': '&#xe903;',
		'tps-bath-tub': '&#xe904;',
		'tps-bbq': '&#xe905;',
		'tps-bus': '&#xe906;',
		'tps-carpet': '&#xe907;',
		'tps-cd-player': '&#xe908;',
		'tps-cloth-rack': '&#xe909;',
		'tps-computer': '&#xe90a;',
		'tps-cycling': '&#xe90b;',
		'tps-dart': '&#xe90c;',
		'tps-dive': '&#xe90d;',
		'tps-food-drink': '&#xe90e;',
		'tps-free-cancellation': '&#xe90f;',
		'tps-hair-drier': '&#xe910;',
		'tps-hiking': '&#xe911;',
		'tps-laptop': '&#xe912;',
		'tps-media-technology': '&#xe913;',
		'tps-outdoor': '&#xe914;',
		'tps-parking': '&#xe915;',
		'tps-pay': '&#xe916;',
		'tps-restaurant': '&#xe917;',
		'tps-slipper': '&#xe918;',
		'tps-sofa': '&#xe919;',
		'tps-spa': '&#xe91a;',
		'tps-supper-market': '&#xe91b;',
		'tps-swim': '&#xe91c;',
		'tps-taxi': '&#xe91d;',
		'tps-tennis': '&#xe91e;',
		'tps-toilet-paper': '&#xe91f;',
		'tps-wifi': '&#xe920;',
		'0': 0
		},
		els = document.getElementsByTagName('*'),
		i, c, el;
	for (i = 0; ; i += 1) {
		el = els[i];
		if(!el) {
			break;
		}
		c = el.className;
		c = c.match(/tps-[^\s'"]+/);
		if (c && icons[c[0]]) {
			addIcon(el, icons[c[0]]);
		}
	}
}());
