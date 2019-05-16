(function($) {
	"use strict";
	var tpj = jQuery;
	var revapi116;
	tpj(document).ready(function() {
		if(tpj("#rev_slider_116_1").revolution == undefined) {
			revslider_showDoubleJqueryError("#rev_slider_116_1");
		} else {
			revapi116 = tpj("#rev_slider_116_1").show().revolution({
				sliderType: "standard",
				jsFileLocation: "../../revolution/js/",
				sliderLayout: "auto",
				dottedOverlay: "none",
				delay: 9000,
				navigation: {
					keyboardNavigation: "off",
					keyboard_direction: "horizontal",
					mouseScrollNavigation: "off",
					onHoverStop: "off",
					touch: {
						touchenabled: "on",
						swipe_threshold: 75,
						swipe_min_touches: 1,
						swipe_direction: "horizontal",
						drag_block_vertical: false
					},
					arrows: {
						style: "gyges",
						enable: true,
						hide_onmobile: true,
						hide_under: 600,
						hide_onleave: true,
						hide_delay: 200,
						hide_delay_mobile: 1200,
						tmp: '',
						left: {
							h_align: "left",
							v_align: "center",
							h_offset: 30,
							v_offset: 0
						},
						right: {
							h_align: "right",
							v_align: "center",
							h_offset: 30,
							v_offset: 0
						}
					}
				},
				viewPort: {
					enable: true,
					outof: "pause",
					visible_area: "80%"
				},
				gridwidth: 1240,
				gridheight: 645,
				lazyType: "none",
				shadow: 0,
				spinner: "off",
				stopLoop: "off",
				stopAfterLoops: -1,
				stopAtSlide: -1,
				shuffle: "off",
				autoHeight: "off",
				hideThumbsOnMobile: "off",
				hideSliderAtLimit: 0,
				hideCaptionAtLimit: 0,
				hideAllCaptionAtLilmit: 0,
				debugMode: false,
				fallbacks: {
					simplifyAll: "off",
					nextSlideOnWindowFocus: "off",
					disableFocusListener: false,
				}
			});
		}
	});
	$(".menu a").on("click", function() {
		$(".menu").find(".current_menu_item").removeClass("current_menu_item");
		$(this).parent().addClass("current_menu_item");
	});
	$('.appear_count').appear(function() {
		$('.timer').countTo();
	});
	$("#blockquote_slider").owlCarousel({
		autoPlay: 3000,
		touchDrag: true,
		pagination: false,
		paginationSpeed: 1500,
		slideSpeed: 1500,
		singleItem: true
	});
	$("#testimonial_slide").owlCarousel({
		autoPlay: 4000,
		touchDrag: true,
		paginationSpeed: 1500,
		slideSpeed: 1500,
		singleItem: true
	});
	$("#client_testimonial").owlCarousel({
		autoPlay: 5000,
		touchDrag: true,
		paginationSpeed: 1500,
		slideSpeed: 1500,
		singleItem: true
	});
	$("#practice_crousel").owlCarousel({
		autoPlay: false,
		items: 6,
		touchDrag: true,
		itemsDesktop: [1199, 3],
		itemsDesktopSmall: [979, 3],
		paginationSpeed: 1000,
		slideSpeed: 1000,
	});
	$(".crousel_items").owlCarousel({
		autoPlay: true,
		items: 5,
		touchDrag: true,
		itemsDesktop: [1199, 4],
		itemsDesktopSmall: [979, 3],
		paginationSpeed: 1000,
		slideSpeed: 1000,
		pagination: false,
		navigation: true,
		navigationText: ["<i class='fa fa-angle-left'></i>", "<i class='fa fa-angle-right'></i>"]
	});
	$('.thumbnail_slider').bxSlider({
		pagerCustom: '#bx-pager',
		controls: false,
		auto: true
	});
	$(window).on('bind scroll', function() {
		if($(window).scrollTop() > 90) {
			$('.lw_navigation_wrapper').addClass('fixed_menu').slideDown('slow');
		} else {
			$('.lw_navigation_wrapper').removeClass('fixed_menu');
		}
	});
	$(window).on('bind scroll', function() {
		if($(window).scrollTop() > 90) {
			$('.lw_second_nav_wrapper').addClass('fixed_menu_second').slideDown('slow');
		} else {
			$('.lw_second_nav_wrapper').removeClass('fixed_menu_second');
		}
	});
	$(window).on('bind scroll', function() {
		if($(window).scrollTop() > 90) {
			$('.lw_navigation_wrapper_thired').addClass('fixed_menu').slideDown('slow');
		} else {
			$('.lw_navigation_wrapper_thired').removeClass('fixed_menu');
		}
	});
	var size_li = $(".testimonial_wrap_main").size();
	var x = 9;
	$('.testimonial_wrap_main:lt(' + x + ')').show();
	$('#loadmore').on("click", function() {
		x = (x + 5 <= size_li) ? x + 5 : size_li;
		$('.testimonial_wrap_main:lt(' + x + ')').show();
	});
	tabModule.init();
}(jQuery));