/*! jQuery v2.1.4 | (c) 2005, 2015 jQuery Foundation, Inc. | jquery.org/license */ ! function(a, b) {
	"object" == typeof module && "object" == typeof module.exports ? module.exports = a.document ? b(a, !0) : function(a) {
		if(!a.document) throw new Error("jQuery requires a window with a document");
		return b(a)
	} : b(a)
}("undefined" != typeof window ? window : this, function(a, b) {
	var c = [],
		d = c.slice,
		e = c.concat,
		f = c.push,
		g = c.indexOf,
		h = {},
		i = h.toString,
		j = h.hasOwnProperty,
		k = {},
		l = a.document,
		m = "2.1.4",
		n = function(a, b) {
			return new n.fn.init(a, b)
		},
		o = /^[\s\uFEFF\xA0]+|[\s\uFEFF\xA0]+$/g,
		p = /^-ms-/,
		q = /-([\da-z])/gi,
		r = function(a, b) {
			return b.toUpperCase()
		};
	n.fn = n.prototype = {
		jquery: m,
		constructor: n,
		selector: "",
		length: 0,
		toArray: function() {
			return d.call(this)
		},
		get: function(a) {
			return null != a ? 0 > a ? this[a + this.length] : this[a] : d.call(this)
		},
		pushStack: function(a) {
			var b = n.merge(this.constructor(), a);
			return b.prevObject = this, b.context = this.context, b
		},
		each: function(a, b) {
			return n.each(this, a, b)
		},
		map: function(a) {
			return this.pushStack(n.map(this, function(b, c) {
				return a.call(b, c, b)
			}))
		},
		slice: function() {
			return this.pushStack(d.apply(this, arguments))
		},
		first: function() {
			return this.eq(0)
		},
		last: function() {
			return this.eq(-1)
		},
		eq: function(a) {
			var b = this.length,
				c = +a + (0 > a ? b : 0);
			return this.pushStack(c >= 0 && b > c ? [this[c]] : [])
		},
		end: function() {
			return this.prevObject || this.constructor(null)
		},
		push: f,
		sort: c.sort,
		splice: c.splice
	}, n.extend = n.fn.extend = function() {
		var a, b, c, d, e, f, g = arguments[0] || {},
			h = 1,
			i = arguments.length,
			j = !1;
		for("boolean" == typeof g && (j = g, g = arguments[h] || {}, h++), "object" == typeof g || n.isFunction(g) || (g = {}), h === i && (g = this, h--); i > h; h++)
			if(null != (a = arguments[h]))
				for(b in a) c = g[b], d = a[b], g !== d && (j && d && (n.isPlainObject(d) || (e = n.isArray(d))) ? (e ? (e = !1, f = c && n.isArray(c) ? c : []) : f = c && n.isPlainObject(c) ? c : {}, g[b] = n.extend(j, f, d)) : void 0 !== d && (g[b] = d));
		return g
	}, n.extend({
		expando: "jQuery" + (m + Math.random()).replace(/\D/g, ""),
		isReady: !0,
		error: function(a) {
			throw new Error(a)
		},
		noop: function() {},
		isFunction: function(a) {
			return "function" === n.type(a)
		},
		isArray: Array.isArray,
		isWindow: function(a) {
			return null != a && a === a.window
		},
		isNumeric: function(a) {
			return !n.isArray(a) && a - parseFloat(a) + 1 >= 0
		},
		isPlainObject: function(a) {
			return "object" !== n.type(a) || a.nodeType || n.isWindow(a) ? !1 : a.constructor && !j.call(a.constructor.prototype, "isPrototypeOf") ? !1 : !0
		},
		isEmptyObject: function(a) {
			var b;
			for(b in a) return !1;
			return !0
		},
		type: function(a) {
			return null == a ? a + "" : "object" == typeof a || "function" == typeof a ? h[i.call(a)] || "object" : typeof a
		},
		globalEval: function(a) {
			var b, c = eval;
			a = n.trim(a), a && (1 === a.indexOf("use strict") ? (b = l.createElement("script"), b.text = a, l.head.appendChild(b).parentNode.removeChild(b)) : c(a))
		},
		camelCase: function(a) {
			return a.replace(p, "ms-").replace(q, r)
		},
		nodeName: function(a, b) {
			return a.nodeName && a.nodeName.toLowerCase() === b.toLowerCase()
		},
		each: function(a, b, c) {
			var d, e = 0,
				f = a.length,
				g = s(a);
			if(c) {
				if(g) {
					for(; f > e; e++)
						if(d = b.apply(a[e], c), d === !1) break
				} else
					for(e in a)
						if(d = b.apply(a[e], c), d === !1) break
			} else if(g) {
				for(; f > e; e++)
					if(d = b.call(a[e], e, a[e]), d === !1) break
			} else
				for(e in a)
					if(d = b.call(a[e], e, a[e]), d === !1) break;
			return a
		},
		trim: function(a) {
			return null == a ? "" : (a + "").replace(o, "")
		},
		makeArray: function(a, b) {
			var c = b || [];
			return null != a && (s(Object(a)) ? n.merge(c, "string" == typeof a ? [a] : a) : f.call(c, a)), c
		},
		inArray: function(a, b, c) {
			return null == b ? -1 : g.call(b, a, c)
		},
		merge: function(a, b) {
			for(var c = +b.length, d = 0, e = a.length; c > d; d++) a[e++] = b[d];
			return a.length = e, a
		},
		grep: function(a, b, c) {
			for(var d, e = [], f = 0, g = a.length, h = !c; g > f; f++) d = !b(a[f], f), d !== h && e.push(a[f]);
			return e
		},
		map: function(a, b, c) {
			var d, f = 0,
				g = a.length,
				h = s(a),
				i = [];
			if(h)
				for(; g > f; f++) d = b(a[f], f, c), null != d && i.push(d);
			else
				for(f in a) d = b(a[f], f, c), null != d && i.push(d);
			return e.apply([], i)
		},
		guid: 1,
		proxy: function(a, b) {
			var c, e, f;
			return "string" == typeof b && (c = a[b], b = a, a = c), n.isFunction(a) ? (e = d.call(arguments, 2), f = function() {
				return a.apply(b || this, e.concat(d.call(arguments)))
			}, f.guid = a.guid = a.guid || n.guid++, f) : void 0
		},
		now: Date.now,
		support: k
	}), n.each("Boolean Number String Function Array Date RegExp Object Error".split(" "), function(a, b) {
		h["[object " + b + "]"] = b.toLowerCase()
	});

	function s(a) {
		var b = "length" in a && a.length,
			c = n.type(a);
		return "function" === c || n.isWindow(a) ? !1 : 1 === a.nodeType && b ? !0 : "array" === c || 0 === b || "number" == typeof b && b > 0 && b - 1 in a
	}
	var t = function(a) {
		var b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u = "sizzle" + 1 * new Date,
			v = a.document,
			w = 0,
			x = 0,
			y = ha(),
			z = ha(),
			A = ha(),
			B = function(a, b) {
				return a === b && (l = !0), 0
			},
			C = 1 << 31,
			D = {}.hasOwnProperty,
			E = [],
			F = E.pop,
			G = E.push,
			H = E.push,
			I = E.slice,
			J = function(a, b) {
				for(var c = 0, d = a.length; d > c; c++)
					if(a[c] === b) return c;
				return -1
			},
			K = "checked|selected|async|autofocus|autoplay|controls|defer|disabled|hidden|ismap|loop|multiple|open|readonly|required|scoped",
			L = "[\\x20\\t\\r\\n\\f]",
			M = "(?:\\\\.|[\\w-]|[^\\x00-\\xa0])+",
			N = M.replace("w", "w#"),
			O = "\\[" + L + "*(" + M + ")(?:" + L + "*([*^$|!~]?=)" + L + "*(?:'((?:\\\\.|[^\\\\'])*)'|\"((?:\\\\.|[^\\\\\"])*)\"|(" + N + "))|)" + L + "*\\]",
			P = ":(" + M + ")(?:\\((('((?:\\\\.|[^\\\\'])*)'|\"((?:\\\\.|[^\\\\\"])*)\")|((?:\\\\.|[^\\\\()[\\]]|" + O + ")*)|.*)\\)|)",
			Q = new RegExp(L + "+", "g"),
			R = new RegExp("^" + L + "+|((?:^|[^\\\\])(?:\\\\.)*)" + L + "+$", "g"),
			S = new RegExp("^" + L + "*," + L + "*"),
			T = new RegExp("^" + L + "*([>+~]|" + L + ")" + L + "*"),
			U = new RegExp("=" + L + "*([^\\]'\"]*?)" + L + "*\\]", "g"),
			V = new RegExp(P),
			W = new RegExp("^" + N + "$"),
			X = {
				ID: new RegExp("^#(" + M + ")"),
				CLASS: new RegExp("^\\.(" + M + ")"),
				TAG: new RegExp("^(" + M.replace("w", "w*") + ")"),
				ATTR: new RegExp("^" + O),
				PSEUDO: new RegExp("^" + P),
				CHILD: new RegExp("^:(only|first|last|nth|nth-last)-(child|of-type)(?:\\(" + L + "*(even|odd|(([+-]|)(\\d*)n|)" + L + "*(?:([+-]|)" + L + "*(\\d+)|))" + L + "*\\)|)", "i"),
				bool: new RegExp("^(?:" + K + ")$", "i"),
				needsContext: new RegExp("^" + L + "*[>+~]|:(even|odd|eq|gt|lt|nth|first|last)(?:\\(" + L + "*((?:-\\d)?\\d*)" + L + "*\\)|)(?=[^-]|$)", "i")
			},
			Y = /^(?:input|select|textarea|button)$/i,
			Z = /^h\d$/i,
			$ = /^[^{]+\{\s*\[native \w/,
			_ = /^(?:#([\w-]+)|(\w+)|\.([\w-]+))$/,
			aa = /[+~]/,
			ba = /'|\\/g,
			ca = new RegExp("\\\\([\\da-f]{1,6}" + L + "?|(" + L + ")|.)", "ig"),
			da = function(a, b, c) {
				var d = "0x" + b - 65536;
				return d !== d || c ? b : 0 > d ? String.fromCharCode(d + 65536) : String.fromCharCode(d >> 10 | 55296, 1023 & d | 56320)
			},
			ea = function() {
				m()
			};
		try {
			H.apply(E = I.call(v.childNodes), v.childNodes), E[v.childNodes.length].nodeType
		} catch(fa) {
			H = {
				apply: E.length ? function(a, b) {
					G.apply(a, I.call(b))
				} : function(a, b) {
					var c = a.length,
						d = 0;
					while(a[c++] = b[d++]);
					a.length = c - 1
				}
			}
		}

		function ga(a, b, d, e) {
			var f, h, j, k, l, o, r, s, w, x;
			if((b ? b.ownerDocument || b : v) !== n && m(b), b = b || n, d = d || [], k = b.nodeType, "string" != typeof a || !a || 1 !== k && 9 !== k && 11 !== k) return d;
			if(!e && p) {
				if(11 !== k && (f = _.exec(a)))
					if(j = f[1]) {
						if(9 === k) {
							if(h = b.getElementById(j), !h || !h.parentNode) return d;
							if(h.id === j) return d.push(h), d
						} else if(b.ownerDocument && (h = b.ownerDocument.getElementById(j)) && t(b, h) && h.id === j) return d.push(h), d
					} else {
						if(f[2]) return H.apply(d, b.getElementsByTagName(a)), d;
						if((j = f[3]) && c.getElementsByClassName) return H.apply(d, b.getElementsByClassName(j)), d
					}
				if(c.qsa && (!q || !q.test(a))) {
					if(s = r = u, w = b, x = 1 !== k && a, 1 === k && "object" !== b.nodeName.toLowerCase()) {
						o = g(a), (r = b.getAttribute("id")) ? s = r.replace(ba, "\\$&") : b.setAttribute("id", s), s = "[id='" + s + "'] ", l = o.length;
						while(l--) o[l] = s + ra(o[l]);
						w = aa.test(a) && pa(b.parentNode) || b, x = o.join(",")
					}
					if(x) try {
						return H.apply(d, w.querySelectorAll(x)), d
					} catch(y) {} finally {
						r || b.removeAttribute("id")
					}
				}
			}
			return i(a.replace(R, "$1"), b, d, e)
		}

		function ha() {
			var a = [];

			function b(c, e) {
				return a.push(c + " ") > d.cacheLength && delete b[a.shift()], b[c + " "] = e
			}
			return b
		}

		function ia(a) {
			return a[u] = !0, a
		}

		function ja(a) {
			var b = n.createElement("div");
			try {
				return !!a(b)
			} catch(c) {
				return !1
			} finally {
				b.parentNode && b.parentNode.removeChild(b), b = null
			}
		}

		function ka(a, b) {
			var c = a.split("|"),
				e = a.length;
			while(e--) d.attrHandle[c[e]] = b
		}

		function la(a, b) {
			var c = b && a,
				d = c && 1 === a.nodeType && 1 === b.nodeType && (~b.sourceIndex || C) - (~a.sourceIndex || C);
			if(d) return d;
			if(c)
				while(c = c.nextSibling)
					if(c === b) return -1;
			return a ? 1 : -1
		}

		function ma(a) {
			return function(b) {
				var c = b.nodeName.toLowerCase();
				return "input" === c && b.type === a
			}
		}

		function na(a) {
			return function(b) {
				var c = b.nodeName.toLowerCase();
				return("input" === c || "button" === c) && b.type === a
			}
		}

		function oa(a) {
			return ia(function(b) {
				return b = +b, ia(function(c, d) {
					var e, f = a([], c.length, b),
						g = f.length;
					while(g--) c[e = f[g]] && (c[e] = !(d[e] = c[e]))
				})
			})
		}

		function pa(a) {
			return a && "undefined" != typeof a.getElementsByTagName && a
		}
		c = ga.support = {}, f = ga.isXML = function(a) {
			var b = a && (a.ownerDocument || a).documentElement;
			return b ? "HTML" !== b.nodeName : !1
		}, m = ga.setDocument = function(a) {
			var b, e, g = a ? a.ownerDocument || a : v;
			return g !== n && 9 === g.nodeType && g.documentElement ? (n = g, o = g.documentElement, e = g.defaultView, e && e !== e.top && (e.addEventListener ? e.addEventListener("unload", ea, !1) : e.attachEvent && e.attachEvent("onunload", ea)), p = !f(g), c.attributes = ja(function(a) {
				return a.className = "i", !a.getAttribute("className")
			}), c.getElementsByTagName = ja(function(a) {
				return a.appendChild(g.createComment("")), !a.getElementsByTagName("*").length
			}), c.getElementsByClassName = $.test(g.getElementsByClassName), c.getById = ja(function(a) {
				return o.appendChild(a).id = u, !g.getElementsByName || !g.getElementsByName(u).length
			}), c.getById ? (d.find.ID = function(a, b) {
				if("undefined" != typeof b.getElementById && p) {
					var c = b.getElementById(a);
					return c && c.parentNode ? [c] : []
				}
			}, d.filter.ID = function(a) {
				var b = a.replace(ca, da);
				return function(a) {
					return a.getAttribute("id") === b
				}
			}) : (delete d.find.ID, d.filter.ID = function(a) {
				var b = a.replace(ca, da);
				return function(a) {
					var c = "undefined" != typeof a.getAttributeNode && a.getAttributeNode("id");
					return c && c.value === b
				}
			}), d.find.TAG = c.getElementsByTagName ? function(a, b) {
				return "undefined" != typeof b.getElementsByTagName ? b.getElementsByTagName(a) : c.qsa ? b.querySelectorAll(a) : void 0
			} : function(a, b) {
				var c, d = [],
					e = 0,
					f = b.getElementsByTagName(a);
				if("*" === a) {
					while(c = f[e++]) 1 === c.nodeType && d.push(c);
					return d
				}
				return f
			}, d.find.CLASS = c.getElementsByClassName && function(a, b) {
				return p ? b.getElementsByClassName(a) : void 0
			}, r = [], q = [], (c.qsa = $.test(g.querySelectorAll)) && (ja(function(a) {
				o.appendChild(a).innerHTML = "<a id='" + u + "'></a><select id='" + u + "-\f]' msallowcapture=''><option selected=''></option></select>", a.querySelectorAll("[msallowcapture^='']").length && q.push("[*^$]=" + L + "*(?:''|\"\")"), a.querySelectorAll("[selected]").length || q.push("\\[" + L + "*(?:value|" + K + ")"), a.querySelectorAll("[id~=" + u + "-]").length || q.push("~="), a.querySelectorAll(":checked").length || q.push(":checked"), a.querySelectorAll("a#" + u + "+*").length || q.push(".#.+[+~]")
			}), ja(function(a) {
				var b = g.createElement("input");
				b.setAttribute("type", "hidden"), a.appendChild(b).setAttribute("name", "D"), a.querySelectorAll("[name=d]").length && q.push("name" + L + "*[*^$|!~]?="), a.querySelectorAll(":enabled").length || q.push(":enabled", ":disabled"), a.querySelectorAll("*,:x"), q.push(",.*:")
			})), (c.matchesSelector = $.test(s = o.matches || o.webkitMatchesSelector || o.mozMatchesSelector || o.oMatchesSelector || o.msMatchesSelector)) && ja(function(a) {
				c.disconnectedMatch = s.call(a, "div"), s.call(a, "[s!='']:x"), r.push("!=", P)
			}), q = q.length && new RegExp(q.join("|")), r = r.length && new RegExp(r.join("|")), b = $.test(o.compareDocumentPosition), t = b || $.test(o.contains) ? function(a, b) {
				var c = 9 === a.nodeType ? a.documentElement : a,
					d = b && b.parentNode;
				return a === d || !(!d || 1 !== d.nodeType || !(c.contains ? c.contains(d) : a.compareDocumentPosition && 16 & a.compareDocumentPosition(d)))
			} : function(a, b) {
				if(b)
					while(b = b.parentNode)
						if(b === a) return !0;
				return !1
			}, B = b ? function(a, b) {
				if(a === b) return l = !0, 0;
				var d = !a.compareDocumentPosition - !b.compareDocumentPosition;
				return d ? d : (d = (a.ownerDocument || a) === (b.ownerDocument || b) ? a.compareDocumentPosition(b) : 1, 1 & d || !c.sortDetached && b.compareDocumentPosition(a) === d ? a === g || a.ownerDocument === v && t(v, a) ? -1 : b === g || b.ownerDocument === v && t(v, b) ? 1 : k ? J(k, a) - J(k, b) : 0 : 4 & d ? -1 : 1)
			} : function(a, b) {
				if(a === b) return l = !0, 0;
				var c, d = 0,
					e = a.parentNode,
					f = b.parentNode,
					h = [a],
					i = [b];
				if(!e || !f) return a === g ? -1 : b === g ? 1 : e ? -1 : f ? 1 : k ? J(k, a) - J(k, b) : 0;
				if(e === f) return la(a, b);
				c = a;
				while(c = c.parentNode) h.unshift(c);
				c = b;
				while(c = c.parentNode) i.unshift(c);
				while(h[d] === i[d]) d++;
				return d ? la(h[d], i[d]) : h[d] === v ? -1 : i[d] === v ? 1 : 0
			}, g) : n
		}, ga.matches = function(a, b) {
			return ga(a, null, null, b)
		}, ga.matchesSelector = function(a, b) {
			if((a.ownerDocument || a) !== n && m(a), b = b.replace(U, "='$1']"), !(!c.matchesSelector || !p || r && r.test(b) || q && q.test(b))) try {
				var d = s.call(a, b);
				if(d || c.disconnectedMatch || a.document && 11 !== a.document.nodeType) return d
			} catch(e) {}
			return ga(b, n, null, [a]).length > 0
		}, ga.contains = function(a, b) {
			return(a.ownerDocument || a) !== n && m(a), t(a, b)
		}, ga.attr = function(a, b) {
			(a.ownerDocument || a) !== n && m(a);
			var e = d.attrHandle[b.toLowerCase()],
				f = e && D.call(d.attrHandle, b.toLowerCase()) ? e(a, b, !p) : void 0;
			return void 0 !== f ? f : c.attributes || !p ? a.getAttribute(b) : (f = a.getAttributeNode(b)) && f.specified ? f.value : null
		}, ga.error = function(a) {
			throw new Error("Syntax error, unrecognized expression: " + a)
		}, ga.uniqueSort = function(a) {
			var b, d = [],
				e = 0,
				f = 0;
			if(l = !c.detectDuplicates, k = !c.sortStable && a.slice(0), a.sort(B), l) {
				while(b = a[f++]) b === a[f] && (e = d.push(f));
				while(e--) a.splice(d[e], 1)
			}
			return k = null, a
		}, e = ga.getText = function(a) {
			var b, c = "",
				d = 0,
				f = a.nodeType;
			if(f) {
				if(1 === f || 9 === f || 11 === f) {
					if("string" == typeof a.textContent) return a.textContent;
					for(a = a.firstChild; a; a = a.nextSibling) c += e(a)
				} else if(3 === f || 4 === f) return a.nodeValue
			} else
				while(b = a[d++]) c += e(b);
			return c
		}, d = ga.selectors = {
			cacheLength: 50,
			createPseudo: ia,
			match: X,
			attrHandle: {},
			find: {},
			relative: {
				">": {
					dir: "parentNode",
					first: !0
				},
				" ": {
					dir: "parentNode"
				},
				"+": {
					dir: "previousSibling",
					first: !0
				},
				"~": {
					dir: "previousSibling"
				}
			},
			preFilter: {
				ATTR: function(a) {
					return a[1] = a[1].replace(ca, da), a[3] = (a[3] || a[4] || a[5] || "").replace(ca, da), "~=" === a[2] && (a[3] = " " + a[3] + " "), a.slice(0, 4)
				},
				CHILD: function(a) {
					return a[1] = a[1].toLowerCase(), "nth" === a[1].slice(0, 3) ? (a[3] || ga.error(a[0]), a[4] = +(a[4] ? a[5] + (a[6] || 1) : 2 * ("even" === a[3] || "odd" === a[3])), a[5] = +(a[7] + a[8] || "odd" === a[3])) : a[3] && ga.error(a[0]), a
				},
				PSEUDO: function(a) {
					var b, c = !a[6] && a[2];
					return X.CHILD.test(a[0]) ? null : (a[3] ? a[2] = a[4] || a[5] || "" : c && V.test(c) && (b = g(c, !0)) && (b = c.indexOf(")", c.length - b) - c.length) && (a[0] = a[0].slice(0, b), a[2] = c.slice(0, b)), a.slice(0, 3))
				}
			},
			filter: {
				TAG: function(a) {
					var b = a.replace(ca, da).toLowerCase();
					return "*" === a ? function() {
						return !0
					} : function(a) {
						return a.nodeName && a.nodeName.toLowerCase() === b
					}
				},
				CLASS: function(a) {
					var b = y[a + " "];
					return b || (b = new RegExp("(^|" + L + ")" + a + "(" + L + "|$)")) && y(a, function(a) {
						return b.test("string" == typeof a.className && a.className || "undefined" != typeof a.getAttribute && a.getAttribute("class") || "")
					})
				},
				ATTR: function(a, b, c) {
					return function(d) {
						var e = ga.attr(d, a);
						return null == e ? "!=" === b : b ? (e += "", "=" === b ? e === c : "!=" === b ? e !== c : "^=" === b ? c && 0 === e.indexOf(c) : "*=" === b ? c && e.indexOf(c) > -1 : "$=" === b ? c && e.slice(-c.length) === c : "~=" === b ? (" " + e.replace(Q, " ") + " ").indexOf(c) > -1 : "|=" === b ? e === c || e.slice(0, c.length + 1) === c + "-" : !1) : !0
					}
				},
				CHILD: function(a, b, c, d, e) {
					var f = "nth" !== a.slice(0, 3),
						g = "last" !== a.slice(-4),
						h = "of-type" === b;
					return 1 === d && 0 === e ? function(a) {
						return !!a.parentNode
					} : function(b, c, i) {
						var j, k, l, m, n, o, p = f !== g ? "nextSibling" : "previousSibling",
							q = b.parentNode,
							r = h && b.nodeName.toLowerCase(),
							s = !i && !h;
						if(q) {
							if(f) {
								while(p) {
									l = b;
									while(l = l[p])
										if(h ? l.nodeName.toLowerCase() === r : 1 === l.nodeType) return !1;
									o = p = "only" === a && !o && "nextSibling"
								}
								return !0
							}
							if(o = [g ? q.firstChild : q.lastChild], g && s) {
								k = q[u] || (q[u] = {}), j = k[a] || [], n = j[0] === w && j[1], m = j[0] === w && j[2], l = n && q.childNodes[n];
								while(l = ++n && l && l[p] || (m = n = 0) || o.pop())
									if(1 === l.nodeType && ++m && l === b) {
										k[a] = [w, n, m];
										break
									}
							} else if(s && (j = (b[u] || (b[u] = {}))[a]) && j[0] === w) m = j[1];
							else
								while(l = ++n && l && l[p] || (m = n = 0) || o.pop())
									if((h ? l.nodeName.toLowerCase() === r : 1 === l.nodeType) && ++m && (s && ((l[u] || (l[u] = {}))[a] = [w, m]), l === b)) break;
							return m -= e, m === d || m % d === 0 && m / d >= 0
						}
					}
				},
				PSEUDO: function(a, b) {
					var c, e = d.pseudos[a] || d.setFilters[a.toLowerCase()] || ga.error("unsupported pseudo: " + a);
					return e[u] ? e(b) : e.length > 1 ? (c = [a, a, "", b], d.setFilters.hasOwnProperty(a.toLowerCase()) ? ia(function(a, c) {
						var d, f = e(a, b),
							g = f.length;
						while(g--) d = J(a, f[g]), a[d] = !(c[d] = f[g])
					}) : function(a) {
						return e(a, 0, c)
					}) : e
				}
			},
			pseudos: {
				not: ia(function(a) {
					var b = [],
						c = [],
						d = h(a.replace(R, "$1"));
					return d[u] ? ia(function(a, b, c, e) {
						var f, g = d(a, null, e, []),
							h = a.length;
						while(h--)(f = g[h]) && (a[h] = !(b[h] = f))
					}) : function(a, e, f) {
						return b[0] = a, d(b, null, f, c), b[0] = null, !c.pop()
					}
				}),
				has: ia(function(a) {
					return function(b) {
						return ga(a, b).length > 0
					}
				}),
				contains: ia(function(a) {
					return a = a.replace(ca, da),
						function(b) {
							return(b.textContent || b.innerText || e(b)).indexOf(a) > -1
						}
				}),
				lang: ia(function(a) {
					return W.test(a || "") || ga.error("unsupported lang: " + a), a = a.replace(ca, da).toLowerCase(),
						function(b) {
							var c;
							do
								if(c = p ? b.lang : b.getAttribute("xml:lang") || b.getAttribute("lang")) return c = c.toLowerCase(), c === a || 0 === c.indexOf(a + "-"); while ((b = b.parentNode) && 1 === b.nodeType);
							return !1
						}
				}),
				target: function(b) {
					var c = a.location && a.location.hash;
					return c && c.slice(1) === b.id
				},
				root: function(a) {
					return a === o
				},
				focus: function(a) {
					return a === n.activeElement && (!n.hasFocus || n.hasFocus()) && !!(a.type || a.href || ~a.tabIndex)
				},
				enabled: function(a) {
					return a.disabled === !1
				},
				disabled: function(a) {
					return a.disabled === !0
				},
				checked: function(a) {
					var b = a.nodeName.toLowerCase();
					return "input" === b && !!a.checked || "option" === b && !!a.selected
				},
				selected: function(a) {
					return a.parentNode && a.parentNode.selectedIndex, a.selected === !0
				},
				empty: function(a) {
					for(a = a.firstChild; a; a = a.nextSibling)
						if(a.nodeType < 6) return !1;
					return !0
				},
				parent: function(a) {
					return !d.pseudos.empty(a)
				},
				header: function(a) {
					return Z.test(a.nodeName)
				},
				input: function(a) {
					return Y.test(a.nodeName)
				},
				button: function(a) {
					var b = a.nodeName.toLowerCase();
					return "input" === b && "button" === a.type || "button" === b
				},
				text: function(a) {
					var b;
					return "input" === a.nodeName.toLowerCase() && "text" === a.type && (null == (b = a.getAttribute("type")) || "text" === b.toLowerCase())
				},
				first: oa(function() {
					return [0]
				}),
				last: oa(function(a, b) {
					return [b - 1]
				}),
				eq: oa(function(a, b, c) {
					return [0 > c ? c + b : c]
				}),
				even: oa(function(a, b) {
					for(var c = 0; b > c; c += 2) a.push(c);
					return a
				}),
				odd: oa(function(a, b) {
					for(var c = 1; b > c; c += 2) a.push(c);
					return a
				}),
				lt: oa(function(a, b, c) {
					for(var d = 0 > c ? c + b : c; --d >= 0;) a.push(d);
					return a
				}),
				gt: oa(function(a, b, c) {
					for(var d = 0 > c ? c + b : c; ++d < b;) a.push(d);
					return a
				})
			}
		}, d.pseudos.nth = d.pseudos.eq;
		for(b in {
				radio: !0,
				checkbox: !0,
				file: !0,
				password: !0,
				image: !0
			}) d.pseudos[b] = ma(b);
		for(b in {
				submit: !0,
				reset: !0
			}) d.pseudos[b] = na(b);

		function qa() {}
		qa.prototype = d.filters = d.pseudos, d.setFilters = new qa, g = ga.tokenize = function(a, b) {
			var c, e, f, g, h, i, j, k = z[a + " "];
			if(k) return b ? 0 : k.slice(0);
			h = a, i = [], j = d.preFilter;
			while(h) {
				(!c || (e = S.exec(h))) && (e && (h = h.slice(e[0].length) || h), i.push(f = [])), c = !1, (e = T.exec(h)) && (c = e.shift(), f.push({
					value: c,
					type: e[0].replace(R, " ")
				}), h = h.slice(c.length));
				for(g in d.filter) !(e = X[g].exec(h)) || j[g] && !(e = j[g](e)) || (c = e.shift(), f.push({
					value: c,
					type: g,
					matches: e
				}), h = h.slice(c.length));
				if(!c) break
			}
			return b ? h.length : h ? ga.error(a) : z(a, i).slice(0)
		};

		function ra(a) {
			for(var b = 0, c = a.length, d = ""; c > b; b++) d += a[b].value;
			return d
		}

		function sa(a, b, c) {
			var d = b.dir,
				e = c && "parentNode" === d,
				f = x++;
			return b.first ? function(b, c, f) {
				while(b = b[d])
					if(1 === b.nodeType || e) return a(b, c, f)
			} : function(b, c, g) {
				var h, i, j = [w, f];
				if(g) {
					while(b = b[d])
						if((1 === b.nodeType || e) && a(b, c, g)) return !0
				} else
					while(b = b[d])
						if(1 === b.nodeType || e) {
							if(i = b[u] || (b[u] = {}), (h = i[d]) && h[0] === w && h[1] === f) return j[2] = h[2];
							if(i[d] = j, j[2] = a(b, c, g)) return !0
						}
			}
		}

		function ta(a) {
			return a.length > 1 ? function(b, c, d) {
				var e = a.length;
				while(e--)
					if(!a[e](b, c, d)) return !1;
				return !0
			} : a[0]
		}

		function ua(a, b, c) {
			for(var d = 0, e = b.length; e > d; d++) ga(a, b[d], c);
			return c
		}

		function va(a, b, c, d, e) {
			for(var f, g = [], h = 0, i = a.length, j = null != b; i > h; h++)(f = a[h]) && (!c || c(f, d, e)) && (g.push(f), j && b.push(h));
			return g
		}

		function wa(a, b, c, d, e, f) {
			return d && !d[u] && (d = wa(d)), e && !e[u] && (e = wa(e, f)), ia(function(f, g, h, i) {
				var j, k, l, m = [],
					n = [],
					o = g.length,
					p = f || ua(b || "*", h.nodeType ? [h] : h, []),
					q = !a || !f && b ? p : va(p, m, a, h, i),
					r = c ? e || (f ? a : o || d) ? [] : g : q;
				if(c && c(q, r, h, i), d) {
					j = va(r, n), d(j, [], h, i), k = j.length;
					while(k--)(l = j[k]) && (r[n[k]] = !(q[n[k]] = l))
				}
				if(f) {
					if(e || a) {
						if(e) {
							j = [], k = r.length;
							while(k--)(l = r[k]) && j.push(q[k] = l);
							e(null, r = [], j, i)
						}
						k = r.length;
						while(k--)(l = r[k]) && (j = e ? J(f, l) : m[k]) > -1 && (f[j] = !(g[j] = l))
					}
				} else r = va(r === g ? r.splice(o, r.length) : r), e ? e(null, g, r, i) : H.apply(g, r)
			})
		}

		function xa(a) {
			for(var b, c, e, f = a.length, g = d.relative[a[0].type], h = g || d.relative[" "], i = g ? 1 : 0, k = sa(function(a) {
					return a === b
				}, h, !0), l = sa(function(a) {
					return J(b, a) > -1
				}, h, !0), m = [function(a, c, d) {
					var e = !g && (d || c !== j) || ((b = c).nodeType ? k(a, c, d) : l(a, c, d));
					return b = null, e
				}]; f > i; i++)
				if(c = d.relative[a[i].type]) m = [sa(ta(m), c)];
				else {
					if(c = d.filter[a[i].type].apply(null, a[i].matches), c[u]) {
						for(e = ++i; f > e; e++)
							if(d.relative[a[e].type]) break;
						return wa(i > 1 && ta(m), i > 1 && ra(a.slice(0, i - 1).concat({
							value: " " === a[i - 2].type ? "*" : ""
						})).replace(R, "$1"), c, e > i && xa(a.slice(i, e)), f > e && xa(a = a.slice(e)), f > e && ra(a))
					}
					m.push(c)
				}
			return ta(m)
		}

		function ya(a, b) {
			var c = b.length > 0,
				e = a.length > 0,
				f = function(f, g, h, i, k) {
					var l, m, o, p = 0,
						q = "0",
						r = f && [],
						s = [],
						t = j,
						u = f || e && d.find.TAG("*", k),
						v = w += null == t ? 1 : Math.random() || .1,
						x = u.length;
					for(k && (j = g !== n && g); q !== x && null != (l = u[q]); q++) {
						if(e && l) {
							m = 0;
							while(o = a[m++])
								if(o(l, g, h)) {
									i.push(l);
									break
								}
							k && (w = v)
						}
						c && ((l = !o && l) && p--, f && r.push(l))
					}
					if(p += q, c && q !== p) {
						m = 0;
						while(o = b[m++]) o(r, s, g, h);
						if(f) {
							if(p > 0)
								while(q--) r[q] || s[q] || (s[q] = F.call(i));
							s = va(s)
						}
						H.apply(i, s), k && !f && s.length > 0 && p + b.length > 1 && ga.uniqueSort(i)
					}
					return k && (w = v, j = t), r
				};
			return c ? ia(f) : f
		}
		return h = ga.compile = function(a, b) {
			var c, d = [],
				e = [],
				f = A[a + " "];
			if(!f) {
				b || (b = g(a)), c = b.length;
				while(c--) f = xa(b[c]), f[u] ? d.push(f) : e.push(f);
				f = A(a, ya(e, d)), f.selector = a
			}
			return f
		}, i = ga.select = function(a, b, e, f) {
			var i, j, k, l, m, n = "function" == typeof a && a,
				o = !f && g(a = n.selector || a);
			if(e = e || [], 1 === o.length) {
				if(j = o[0] = o[0].slice(0), j.length > 2 && "ID" === (k = j[0]).type && c.getById && 9 === b.nodeType && p && d.relative[j[1].type]) {
					if(b = (d.find.ID(k.matches[0].replace(ca, da), b) || [])[0], !b) return e;
					n && (b = b.parentNode), a = a.slice(j.shift().value.length)
				}
				i = X.needsContext.test(a) ? 0 : j.length;
				while(i--) {
					if(k = j[i], d.relative[l = k.type]) break;
					if((m = d.find[l]) && (f = m(k.matches[0].replace(ca, da), aa.test(j[0].type) && pa(b.parentNode) || b))) {
						if(j.splice(i, 1), a = f.length && ra(j), !a) return H.apply(e, f), e;
						break
					}
				}
			}
			return(n || h(a, o))(f, b, !p, e, aa.test(a) && pa(b.parentNode) || b), e
		}, c.sortStable = u.split("").sort(B).join("") === u, c.detectDuplicates = !!l, m(), c.sortDetached = ja(function(a) {
			return 1 & a.compareDocumentPosition(n.createElement("div"))
		}), ja(function(a) {
			return a.innerHTML = "<a href='#'></a>", "#" === a.firstChild.getAttribute("href")
		}) || ka("type|href|height|width", function(a, b, c) {
			return c ? void 0 : a.getAttribute(b, "type" === b.toLowerCase() ? 1 : 2)
		}), c.attributes && ja(function(a) {
			return a.innerHTML = "<input/>", a.firstChild.setAttribute("value", ""), "" === a.firstChild.getAttribute("value")
		}) || ka("value", function(a, b, c) {
			return c || "input" !== a.nodeName.toLowerCase() ? void 0 : a.defaultValue
		}), ja(function(a) {
			return null == a.getAttribute("disabled")
		}) || ka(K, function(a, b, c) {
			var d;
			return c ? void 0 : a[b] === !0 ? b.toLowerCase() : (d = a.getAttributeNode(b)) && d.specified ? d.value : null
		}), ga
	}(a);
	n.find = t, n.expr = t.selectors, n.expr[":"] = n.expr.pseudos, n.unique = t.uniqueSort, n.text = t.getText, n.isXMLDoc = t.isXML, n.contains = t.contains;
	var u = n.expr.match.needsContext,
		v = /^<(\w+)\s*\/?>(?:<\/\1>|)$/,
		w = /^.[^:#\[\.,]*$/;

	function x(a, b, c) {
		if(n.isFunction(b)) return n.grep(a, function(a, d) {
			return !!b.call(a, d, a) !== c
		});
		if(b.nodeType) return n.grep(a, function(a) {
			return a === b !== c
		});
		if("string" == typeof b) {
			if(w.test(b)) return n.filter(b, a, c);
			b = n.filter(b, a)
		}
		return n.grep(a, function(a) {
			return g.call(b, a) >= 0 !== c
		})
	}
	n.filter = function(a, b, c) {
		var d = b[0];
		return c && (a = ":not(" + a + ")"), 1 === b.length && 1 === d.nodeType ? n.find.matchesSelector(d, a) ? [d] : [] : n.find.matches(a, n.grep(b, function(a) {
			return 1 === a.nodeType
		}))
	}, n.fn.extend({
		find: function(a) {
			var b, c = this.length,
				d = [],
				e = this;
			if("string" != typeof a) return this.pushStack(n(a).filter(function() {
				for(b = 0; c > b; b++)
					if(n.contains(e[b], this)) return !0
			}));
			for(b = 0; c > b; b++) n.find(a, e[b], d);
			return d = this.pushStack(c > 1 ? n.unique(d) : d), d.selector = this.selector ? this.selector + " " + a : a, d
		},
		filter: function(a) {
			return this.pushStack(x(this, a || [], !1))
		},
		not: function(a) {
			return this.pushStack(x(this, a || [], !0))
		},
		is: function(a) {
			return !!x(this, "string" == typeof a && u.test(a) ? n(a) : a || [], !1).length
		}
	});
	var y, z = /^(?:\s*(<[\w\W]+>)[^>]*|#([\w-]*))$/,
		A = n.fn.init = function(a, b) {
			var c, d;
			if(!a) return this;
			if("string" == typeof a) {
				if(c = "<" === a[0] && ">" === a[a.length - 1] && a.length >= 3 ? [null, a, null] : z.exec(a), !c || !c[1] && b) return !b || b.jquery ? (b || y).find(a) : this.constructor(b).find(a);
				if(c[1]) {
					if(b = b instanceof n ? b[0] : b, n.merge(this, n.parseHTML(c[1], b && b.nodeType ? b.ownerDocument || b : l, !0)), v.test(c[1]) && n.isPlainObject(b))
						for(c in b) n.isFunction(this[c]) ? this[c](b[c]) : this.attr(c, b[c]);
					return this
				}
				return d = l.getElementById(c[2]), d && d.parentNode && (this.length = 1, this[0] = d), this.context = l, this.selector = a, this
			}
			return a.nodeType ? (this.context = this[0] = a, this.length = 1, this) : n.isFunction(a) ? "undefined" != typeof y.ready ? y.ready(a) : a(n) : (void 0 !== a.selector && (this.selector = a.selector, this.context = a.context), n.makeArray(a, this))
		};
	A.prototype = n.fn, y = n(l);
	var B = /^(?:parents|prev(?:Until|All))/,
		C = {
			children: !0,
			contents: !0,
			next: !0,
			prev: !0
		};
	n.extend({
		dir: function(a, b, c) {
			var d = [],
				e = void 0 !== c;
			while((a = a[b]) && 9 !== a.nodeType)
				if(1 === a.nodeType) {
					if(e && n(a).is(c)) break;
					d.push(a)
				}
			return d
		},
		sibling: function(a, b) {
			for(var c = []; a; a = a.nextSibling) 1 === a.nodeType && a !== b && c.push(a);
			return c
		}
	}), n.fn.extend({
		has: function(a) {
			var b = n(a, this),
				c = b.length;
			return this.filter(function() {
				for(var a = 0; c > a; a++)
					if(n.contains(this, b[a])) return !0
			})
		},
		closest: function(a, b) {
			for(var c, d = 0, e = this.length, f = [], g = u.test(a) || "string" != typeof a ? n(a, b || this.context) : 0; e > d; d++)
				for(c = this[d]; c && c !== b; c = c.parentNode)
					if(c.nodeType < 11 && (g ? g.index(c) > -1 : 1 === c.nodeType && n.find.matchesSelector(c, a))) {
						f.push(c);
						break
					}
			return this.pushStack(f.length > 1 ? n.unique(f) : f)
		},
		index: function(a) {
			return a ? "string" == typeof a ? g.call(n(a), this[0]) : g.call(this, a.jquery ? a[0] : a) : this[0] && this[0].parentNode ? this.first().prevAll().length : -1
		},
		add: function(a, b) {
			return this.pushStack(n.unique(n.merge(this.get(), n(a, b))))
		},
		addBack: function(a) {
			return this.add(null == a ? this.prevObject : this.prevObject.filter(a))
		}
	});

	function D(a, b) {
		while((a = a[b]) && 1 !== a.nodeType);
		return a
	}
	n.each({
		parent: function(a) {
			var b = a.parentNode;
			return b && 11 !== b.nodeType ? b : null
		},
		parents: function(a) {
			return n.dir(a, "parentNode")
		},
		parentsUntil: function(a, b, c) {
			return n.dir(a, "parentNode", c)
		},
		next: function(a) {
			return D(a, "nextSibling")
		},
		prev: function(a) {
			return D(a, "previousSibling")
		},
		nextAll: function(a) {
			return n.dir(a, "nextSibling")
		},
		prevAll: function(a) {
			return n.dir(a, "previousSibling")
		},
		nextUntil: function(a, b, c) {
			return n.dir(a, "nextSibling", c)
		},
		prevUntil: function(a, b, c) {
			return n.dir(a, "previousSibling", c)
		},
		siblings: function(a) {
			return n.sibling((a.parentNode || {}).firstChild, a)
		},
		children: function(a) {
			return n.sibling(a.firstChild)
		},
		contents: function(a) {
			return a.contentDocument || n.merge([], a.childNodes)
		}
	}, function(a, b) {
		n.fn[a] = function(c, d) {
			var e = n.map(this, b, c);
			return "Until" !== a.slice(-5) && (d = c), d && "string" == typeof d && (e = n.filter(d, e)), this.length > 1 && (C[a] || n.unique(e), B.test(a) && e.reverse()), this.pushStack(e)
		}
	});
	var E = /\S+/g,
		F = {};

	function G(a) {
		var b = F[a] = {};
		return n.each(a.match(E) || [], function(a, c) {
			b[c] = !0
		}), b
	}
	n.Callbacks = function(a) {
		a = "string" == typeof a ? F[a] || G(a) : n.extend({}, a);
		var b, c, d, e, f, g, h = [],
			i = !a.once && [],
			j = function(l) {
				for(b = a.memory && l, c = !0, g = e || 0, e = 0, f = h.length, d = !0; h && f > g; g++)
					if(h[g].apply(l[0], l[1]) === !1 && a.stopOnFalse) {
						b = !1;
						break
					}
				d = !1, h && (i ? i.length && j(i.shift()) : b ? h = [] : k.disable())
			},
			k = {
				add: function() {
					if(h) {
						var c = h.length;
						! function g(b) {
							n.each(b, function(b, c) {
								var d = n.type(c);
								"function" === d ? a.unique && k.has(c) || h.push(c) : c && c.length && "string" !== d && g(c)
							})
						}(arguments), d ? f = h.length : b && (e = c, j(b))
					}
					return this
				},
				remove: function() {
					return h && n.each(arguments, function(a, b) {
						var c;
						while((c = n.inArray(b, h, c)) > -1) h.splice(c, 1), d && (f >= c && f--, g >= c && g--)
					}), this
				},
				has: function(a) {
					return a ? n.inArray(a, h) > -1 : !(!h || !h.length)
				},
				empty: function() {
					return h = [], f = 0, this
				},
				disable: function() {
					return h = i = b = void 0, this
				},
				disabled: function() {
					return !h
				},
				lock: function() {
					return i = void 0, b || k.disable(), this
				},
				locked: function() {
					return !i
				},
				fireWith: function(a, b) {
					return !h || c && !i || (b = b || [], b = [a, b.slice ? b.slice() : b], d ? i.push(b) : j(b)), this
				},
				fire: function() {
					return k.fireWith(this, arguments), this
				},
				fired: function() {
					return !!c
				}
			};
		return k
	}, n.extend({
		Deferred: function(a) {
			var b = [
					["resolve", "done", n.Callbacks("once memory"), "resolved"],
					["reject", "fail", n.Callbacks("once memory"), "rejected"],
					["notify", "progress", n.Callbacks("memory")]
				],
				c = "pending",
				d = {
					state: function() {
						return c
					},
					always: function() {
						return e.done(arguments).fail(arguments), this
					},
					then: function() {
						var a = arguments;
						return n.Deferred(function(c) {
							n.each(b, function(b, f) {
								var g = n.isFunction(a[b]) && a[b];
								e[f[1]](function() {
									var a = g && g.apply(this, arguments);
									a && n.isFunction(a.promise) ? a.promise().done(c.resolve).fail(c.reject).progress(c.notify) : c[f[0] + "With"](this === d ? c.promise() : this, g ? [a] : arguments)
								})
							}), a = null
						}).promise()
					},
					promise: function(a) {
						return null != a ? n.extend(a, d) : d
					}
				},
				e = {};
			return d.pipe = d.then, n.each(b, function(a, f) {
				var g = f[2],
					h = f[3];
				d[f[1]] = g.add, h && g.add(function() {
					c = h
				}, b[1 ^ a][2].disable, b[2][2].lock), e[f[0]] = function() {
					return e[f[0] + "With"](this === e ? d : this, arguments), this
				}, e[f[0] + "With"] = g.fireWith
			}), d.promise(e), a && a.call(e, e), e
		},
		when: function(a) {
			var b = 0,
				c = d.call(arguments),
				e = c.length,
				f = 1 !== e || a && n.isFunction(a.promise) ? e : 0,
				g = 1 === f ? a : n.Deferred(),
				h = function(a, b, c) {
					return function(e) {
						b[a] = this, c[a] = arguments.length > 1 ? d.call(arguments) : e, c === i ? g.notifyWith(b, c) : --f || g.resolveWith(b, c)
					}
				},
				i, j, k;
			if(e > 1)
				for(i = new Array(e), j = new Array(e), k = new Array(e); e > b; b++) c[b] && n.isFunction(c[b].promise) ? c[b].promise().done(h(b, k, c)).fail(g.reject).progress(h(b, j, i)) : --f;
			return f || g.resolveWith(k, c), g.promise()
		}
	});
	var H;
	n.fn.ready = function(a) {
		return n.ready.promise().done(a), this
	}, n.extend({
		isReady: !1,
		readyWait: 1,
		holdReady: function(a) {
			a ? n.readyWait++ : n.ready(!0)
		},
		ready: function(a) {
			(a === !0 ? --n.readyWait : n.isReady) || (n.isReady = !0, a !== !0 && --n.readyWait > 0 || (H.resolveWith(l, [n]), n.fn.triggerHandler && (n(l).triggerHandler("ready"), n(l).off("ready"))))
		}
	});

	function I() {
		l.removeEventListener("DOMContentLoaded", I, !1), a.removeEventListener("load", I, !1), n.ready()
	}
	n.ready.promise = function(b) {
		return H || (H = n.Deferred(), "complete" === l.readyState ? setTimeout(n.ready) : (l.addEventListener("DOMContentLoaded", I, !1), a.addEventListener("load", I, !1))), H.promise(b)
	}, n.ready.promise();
	var J = n.access = function(a, b, c, d, e, f, g) {
		var h = 0,
			i = a.length,
			j = null == c;
		if("object" === n.type(c)) {
			e = !0;
			for(h in c) n.access(a, b, h, c[h], !0, f, g)
		} else if(void 0 !== d && (e = !0, n.isFunction(d) || (g = !0), j && (g ? (b.call(a, d), b = null) : (j = b, b = function(a, b, c) {
				return j.call(n(a), c)
			})), b))
			for(; i > h; h++) b(a[h], c, g ? d : d.call(a[h], h, b(a[h], c)));
		return e ? a : j ? b.call(a) : i ? b(a[0], c) : f
	};
	n.acceptData = function(a) {
		return 1 === a.nodeType || 9 === a.nodeType || !+a.nodeType
	};

	function K() {
		Object.defineProperty(this.cache = {}, 0, {
			get: function() {
				return {}
			}
		}), this.expando = n.expando + K.uid++
	}
	K.uid = 1, K.accepts = n.acceptData, K.prototype = {
		key: function(a) {
			if(!K.accepts(a)) return 0;
			var b = {},
				c = a[this.expando];
			if(!c) {
				c = K.uid++;
				try {
					b[this.expando] = {
						value: c
					}, Object.defineProperties(a, b)
				} catch(d) {
					b[this.expando] = c, n.extend(a, b)
				}
			}
			return this.cache[c] || (this.cache[c] = {}), c
		},
		set: function(a, b, c) {
			var d, e = this.key(a),
				f = this.cache[e];
			if("string" == typeof b) f[b] = c;
			else if(n.isEmptyObject(f)) n.extend(this.cache[e], b);
			else
				for(d in b) f[d] = b[d];
			return f
		},
		get: function(a, b) {
			var c = this.cache[this.key(a)];
			return void 0 === b ? c : c[b]
		},
		access: function(a, b, c) {
			var d;
			return void 0 === b || b && "string" == typeof b && void 0 === c ? (d = this.get(a, b), void 0 !== d ? d : this.get(a, n.camelCase(b))) : (this.set(a, b, c), void 0 !== c ? c : b)
		},
		remove: function(a, b) {
			var c, d, e, f = this.key(a),
				g = this.cache[f];
			if(void 0 === b) this.cache[f] = {};
			else {
				n.isArray(b) ? d = b.concat(b.map(n.camelCase)) : (e = n.camelCase(b), b in g ? d = [b, e] : (d = e, d = d in g ? [d] : d.match(E) || [])), c = d.length;
				while(c--) delete g[d[c]]
			}
		},
		hasData: function(a) {
			return !n.isEmptyObject(this.cache[a[this.expando]] || {})
		},
		discard: function(a) {
			a[this.expando] && delete this.cache[a[this.expando]]
		}
	};
	var L = new K,
		M = new K,
		N = /^(?:\{[\w\W]*\}|\[[\w\W]*\])$/,
		O = /([A-Z])/g;

	function P(a, b, c) {
		var d;
		if(void 0 === c && 1 === a.nodeType)
			if(d = "data-" + b.replace(O, "-$1").toLowerCase(), c = a.getAttribute(d), "string" == typeof c) {
				try {
					c = "true" === c ? !0 : "false" === c ? !1 : "null" === c ? null : +c + "" === c ? +c : N.test(c) ? n.parseJSON(c) : c
				} catch(e) {}
				M.set(a, b, c)
			} else c = void 0;
		return c
	}
	n.extend({
		hasData: function(a) {
			return M.hasData(a) || L.hasData(a)
		},
		data: function(a, b, c) {
			return M.access(a, b, c)
		},
		removeData: function(a, b) {
			M.remove(a, b)
		},
		_data: function(a, b, c) {
			return L.access(a, b, c)
		},
		_removeData: function(a, b) {
			L.remove(a, b)
		}
	}), n.fn.extend({
		data: function(a, b) {
			var c, d, e, f = this[0],
				g = f && f.attributes;
			if(void 0 === a) {
				if(this.length && (e = M.get(f), 1 === f.nodeType && !L.get(f, "hasDataAttrs"))) {
					c = g.length;
					while(c--) g[c] && (d = g[c].name, 0 === d.indexOf("data-") && (d = n.camelCase(d.slice(5)), P(f, d, e[d])));
					L.set(f, "hasDataAttrs", !0)
				}
				return e
			}
			return "object" == typeof a ? this.each(function() {
				M.set(this, a)
			}) : J(this, function(b) {
				var c, d = n.camelCase(a);
				if(f && void 0 === b) {
					if(c = M.get(f, a), void 0 !== c) return c;
					if(c = M.get(f, d), void 0 !== c) return c;
					if(c = P(f, d, void 0), void 0 !== c) return c
				} else this.each(function() {
					var c = M.get(this, d);
					M.set(this, d, b), -1 !== a.indexOf("-") && void 0 !== c && M.set(this, a, b)
				})
			}, null, b, arguments.length > 1, null, !0)
		},
		removeData: function(a) {
			return this.each(function() {
				M.remove(this, a)
			})
		}
	}), n.extend({
		queue: function(a, b, c) {
			var d;
			return a ? (b = (b || "fx") + "queue", d = L.get(a, b), c && (!d || n.isArray(c) ? d = L.access(a, b, n.makeArray(c)) : d.push(c)), d || []) : void 0
		},
		dequeue: function(a, b) {
			b = b || "fx";
			var c = n.queue(a, b),
				d = c.length,
				e = c.shift(),
				f = n._queueHooks(a, b),
				g = function() {
					n.dequeue(a, b)
				};
			"inprogress" === e && (e = c.shift(), d--), e && ("fx" === b && c.unshift("inprogress"), delete f.stop, e.call(a, g, f)), !d && f && f.empty.fire()
		},
		_queueHooks: function(a, b) {
			var c = b + "queueHooks";
			return L.get(a, c) || L.access(a, c, {
				empty: n.Callbacks("once memory").add(function() {
					L.remove(a, [b + "queue", c])
				})
			})
		}
	}), n.fn.extend({
		queue: function(a, b) {
			var c = 2;
			return "string" != typeof a && (b = a, a = "fx", c--), arguments.length < c ? n.queue(this[0], a) : void 0 === b ? this : this.each(function() {
				var c = n.queue(this, a, b);
				n._queueHooks(this, a), "fx" === a && "inprogress" !== c[0] && n.dequeue(this, a)
			})
		},
		dequeue: function(a) {
			return this.each(function() {
				n.dequeue(this, a)
			})
		},
		clearQueue: function(a) {
			return this.queue(a || "fx", [])
		},
		promise: function(a, b) {
			var c, d = 1,
				e = n.Deferred(),
				f = this,
				g = this.length,
				h = function() {
					--d || e.resolveWith(f, [f])
				};
			"string" != typeof a && (b = a, a = void 0), a = a || "fx";
			while(g--) c = L.get(f[g], a + "queueHooks"), c && c.empty && (d++, c.empty.add(h));
			return h(), e.promise(b)
		}
	});
	var Q = /[+-]?(?:\d*\.|)\d+(?:[eE][+-]?\d+|)/.source,
		R = ["Top", "Right", "Bottom", "Left"],
		S = function(a, b) {
			return a = b || a, "none" === n.css(a, "display") || !n.contains(a.ownerDocument, a)
		},
		T = /^(?:checkbox|radio)$/i;
	! function() {
		var a = l.createDocumentFragment(),
			b = a.appendChild(l.createElement("div")),
			c = l.createElement("input");
		c.setAttribute("type", "radio"), c.setAttribute("checked", "checked"), c.setAttribute("name", "t"), b.appendChild(c), k.checkClone = b.cloneNode(!0).cloneNode(!0).lastChild.checked, b.innerHTML = "<textarea>x</textarea>", k.noCloneChecked = !!b.cloneNode(!0).lastChild.defaultValue
	}();
	var U = "undefined";
	k.focusinBubbles = "onfocusin" in a;
	var V = /^key/,
		W = /^(?:mouse|pointer|contextmenu)|click/,
		X = /^(?:focusinfocus|focusoutblur)$/,
		Y = /^([^.]*)(?:\.(.+)|)$/;

	function Z() {
		return !0
	}

	function $() {
		return !1
	}

	function _() {
		try {
			return l.activeElement
		} catch(a) {}
	}
	n.event = {
		global: {},
		add: function(a, b, c, d, e) {
			var f, g, h, i, j, k, l, m, o, p, q, r = L.get(a);
			if(r) {
				c.handler && (f = c, c = f.handler, e = f.selector), c.guid || (c.guid = n.guid++), (i = r.events) || (i = r.events = {}), (g = r.handle) || (g = r.handle = function(b) {
					return typeof n !== U && n.event.triggered !== b.type ? n.event.dispatch.apply(a, arguments) : void 0
				}), b = (b || "").match(E) || [""], j = b.length;
				while(j--) h = Y.exec(b[j]) || [], o = q = h[1], p = (h[2] || "").split(".").sort(), o && (l = n.event.special[o] || {}, o = (e ? l.delegateType : l.bindType) || o, l = n.event.special[o] || {}, k = n.extend({
					type: o,
					origType: q,
					data: d,
					handler: c,
					guid: c.guid,
					selector: e,
					needsContext: e && n.expr.match.needsContext.test(e),
					namespace: p.join(".")
				}, f), (m = i[o]) || (m = i[o] = [], m.delegateCount = 0, l.setup && l.setup.call(a, d, p, g) !== !1 || a.addEventListener && a.addEventListener(o, g, !1)), l.add && (l.add.call(a, k), k.handler.guid || (k.handler.guid = c.guid)), e ? m.splice(m.delegateCount++, 0, k) : m.push(k), n.event.global[o] = !0)
			}
		},
		remove: function(a, b, c, d, e) {
			var f, g, h, i, j, k, l, m, o, p, q, r = L.hasData(a) && L.get(a);
			if(r && (i = r.events)) {
				b = (b || "").match(E) || [""], j = b.length;
				while(j--)
					if(h = Y.exec(b[j]) || [], o = q = h[1], p = (h[2] || "").split(".").sort(), o) {
						l = n.event.special[o] || {}, o = (d ? l.delegateType : l.bindType) || o, m = i[o] || [], h = h[2] && new RegExp("(^|\\.)" + p.join("\\.(?:.*\\.|)") + "(\\.|$)"), g = f = m.length;
						while(f--) k = m[f], !e && q !== k.origType || c && c.guid !== k.guid || h && !h.test(k.namespace) || d && d !== k.selector && ("**" !== d || !k.selector) || (m.splice(f, 1), k.selector && m.delegateCount--, l.remove && l.remove.call(a, k));
						g && !m.length && (l.teardown && l.teardown.call(a, p, r.handle) !== !1 || n.removeEvent(a, o, r.handle), delete i[o])
					} else
						for(o in i) n.event.remove(a, o + b[j], c, d, !0);
				n.isEmptyObject(i) && (delete r.handle, L.remove(a, "events"))
			}
		},
		trigger: function(b, c, d, e) {
			var f, g, h, i, k, m, o, p = [d || l],
				q = j.call(b, "type") ? b.type : b,
				r = j.call(b, "namespace") ? b.namespace.split(".") : [];
			if(g = h = d = d || l, 3 !== d.nodeType && 8 !== d.nodeType && !X.test(q + n.event.triggered) && (q.indexOf(".") >= 0 && (r = q.split("."), q = r.shift(), r.sort()), k = q.indexOf(":") < 0 && "on" + q, b = b[n.expando] ? b : new n.Event(q, "object" == typeof b && b), b.isTrigger = e ? 2 : 3, b.namespace = r.join("."), b.namespace_re = b.namespace ? new RegExp("(^|\\.)" + r.join("\\.(?:.*\\.|)") + "(\\.|$)") : null, b.result = void 0, b.target || (b.target = d), c = null == c ? [b] : n.makeArray(c, [b]), o = n.event.special[q] || {}, e || !o.trigger || o.trigger.apply(d, c) !== !1)) {
				if(!e && !o.noBubble && !n.isWindow(d)) {
					for(i = o.delegateType || q, X.test(i + q) || (g = g.parentNode); g; g = g.parentNode) p.push(g), h = g;
					h === (d.ownerDocument || l) && p.push(h.defaultView || h.parentWindow || a)
				}
				f = 0;
				while((g = p[f++]) && !b.isPropagationStopped()) b.type = f > 1 ? i : o.bindType || q, m = (L.get(g, "events") || {})[b.type] && L.get(g, "handle"), m && m.apply(g, c), m = k && g[k], m && m.apply && n.acceptData(g) && (b.result = m.apply(g, c), b.result === !1 && b.preventDefault());
				return b.type = q, e || b.isDefaultPrevented() || o._default && o._default.apply(p.pop(), c) !== !1 || !n.acceptData(d) || k && n.isFunction(d[q]) && !n.isWindow(d) && (h = d[k], h && (d[k] = null), n.event.triggered = q, d[q](), n.event.triggered = void 0, h && (d[k] = h)), b.result
			}
		},
		dispatch: function(a) {
			a = n.event.fix(a);
			var b, c, e, f, g, h = [],
				i = d.call(arguments),
				j = (L.get(this, "events") || {})[a.type] || [],
				k = n.event.special[a.type] || {};
			if(i[0] = a, a.delegateTarget = this, !k.preDispatch || k.preDispatch.call(this, a) !== !1) {
				h = n.event.handlers.call(this, a, j), b = 0;
				while((f = h[b++]) && !a.isPropagationStopped()) {
					a.currentTarget = f.elem, c = 0;
					while((g = f.handlers[c++]) && !a.isImmediatePropagationStopped())(!a.namespace_re || a.namespace_re.test(g.namespace)) && (a.handleObj = g, a.data = g.data, e = ((n.event.special[g.origType] || {}).handle || g.handler).apply(f.elem, i), void 0 !== e && (a.result = e) === !1 && (a.preventDefault(), a.stopPropagation()))
				}
				return k.postDispatch && k.postDispatch.call(this, a), a.result
			}
		},
		handlers: function(a, b) {
			var c, d, e, f, g = [],
				h = b.delegateCount,
				i = a.target;
			if(h && i.nodeType && (!a.button || "click" !== a.type))
				for(; i !== this; i = i.parentNode || this)
					if(i.disabled !== !0 || "click" !== a.type) {
						for(d = [], c = 0; h > c; c++) f = b[c], e = f.selector + " ", void 0 === d[e] && (d[e] = f.needsContext ? n(e, this).index(i) >= 0 : n.find(e, this, null, [i]).length), d[e] && d.push(f);
						d.length && g.push({
							elem: i,
							handlers: d
						})
					}
			return h < b.length && g.push({
				elem: this,
				handlers: b.slice(h)
			}), g
		},
		props: "altKey bubbles cancelable ctrlKey currentTarget eventPhase metaKey relatedTarget shiftKey target timeStamp view which".split(" "),
		fixHooks: {},
		keyHooks: {
			props: "char charCode key keyCode".split(" "),
			filter: function(a, b) {
				return null == a.which && (a.which = null != b.charCode ? b.charCode : b.keyCode), a
			}
		},
		mouseHooks: {
			props: "button buttons clientX clientY offsetX offsetY pageX pageY screenX screenY toElement".split(" "),
			filter: function(a, b) {
				var c, d, e, f = b.button;
				return null == a.pageX && null != b.clientX && (c = a.target.ownerDocument || l, d = c.documentElement, e = c.body, a.pageX = b.clientX + (d && d.scrollLeft || e && e.scrollLeft || 0) - (d && d.clientLeft || e && e.clientLeft || 0), a.pageY = b.clientY + (d && d.scrollTop || e && e.scrollTop || 0) - (d && d.clientTop || e && e.clientTop || 0)), a.which || void 0 === f || (a.which = 1 & f ? 1 : 2 & f ? 3 : 4 & f ? 2 : 0), a
			}
		},
		fix: function(a) {
			if(a[n.expando]) return a;
			var b, c, d, e = a.type,
				f = a,
				g = this.fixHooks[e];
			g || (this.fixHooks[e] = g = W.test(e) ? this.mouseHooks : V.test(e) ? this.keyHooks : {}), d = g.props ? this.props.concat(g.props) : this.props, a = new n.Event(f), b = d.length;
			while(b--) c = d[b], a[c] = f[c];
			return a.target || (a.target = l), 3 === a.target.nodeType && (a.target = a.target.parentNode), g.filter ? g.filter(a, f) : a
		},
		special: {
			load: {
				noBubble: !0
			},
			focus: {
				trigger: function() {
					return this !== _() && this.focus ? (this.focus(), !1) : void 0
				},
				delegateType: "focusin"
			},
			blur: {
				trigger: function() {
					return this === _() && this.blur ? (this.blur(), !1) : void 0
				},
				delegateType: "focusout"
			},
			click: {
				trigger: function() {
					return "checkbox" === this.type && this.click && n.nodeName(this, "input") ? (this.click(), !1) : void 0
				},
				_default: function(a) {
					return n.nodeName(a.target, "a")
				}
			},
			beforeunload: {
				postDispatch: function(a) {
					void 0 !== a.result && a.originalEvent && (a.originalEvent.returnValue = a.result)
				}
			}
		},
		simulate: function(a, b, c, d) {
			var e = n.extend(new n.Event, c, {
				type: a,
				isSimulated: !0,
				originalEvent: {}
			});
			d ? n.event.trigger(e, null, b) : n.event.dispatch.call(b, e), e.isDefaultPrevented() && c.preventDefault()
		}
	}, n.removeEvent = function(a, b, c) {
		a.removeEventListener && a.removeEventListener(b, c, !1)
	}, n.Event = function(a, b) {
		return this instanceof n.Event ? (a && a.type ? (this.originalEvent = a, this.type = a.type, this.isDefaultPrevented = a.defaultPrevented || void 0 === a.defaultPrevented && a.returnValue === !1 ? Z : $) : this.type = a, b && n.extend(this, b), this.timeStamp = a && a.timeStamp || n.now(), void(this[n.expando] = !0)) : new n.Event(a, b)
	}, n.Event.prototype = {
		isDefaultPrevented: $,
		isPropagationStopped: $,
		isImmediatePropagationStopped: $,
		preventDefault: function() {
			var a = this.originalEvent;
			this.isDefaultPrevented = Z, a && a.preventDefault && a.preventDefault()
		},
		stopPropagation: function() {
			var a = this.originalEvent;
			this.isPropagationStopped = Z, a && a.stopPropagation && a.stopPropagation()
		},
		stopImmediatePropagation: function() {
			var a = this.originalEvent;
			this.isImmediatePropagationStopped = Z, a && a.stopImmediatePropagation && a.stopImmediatePropagation(), this.stopPropagation()
		}
	}, n.each({
		mouseenter: "mouseover",
		mouseleave: "mouseout",
		pointerenter: "pointerover",
		pointerleave: "pointerout"
	}, function(a, b) {
		n.event.special[a] = {
			delegateType: b,
			bindType: b,
			handle: function(a) {
				var c, d = this,
					e = a.relatedTarget,
					f = a.handleObj;
				return(!e || e !== d && !n.contains(d, e)) && (a.type = f.origType, c = f.handler.apply(this, arguments), a.type = b), c
			}
		}
	}), k.focusinBubbles || n.each({
		focus: "focusin",
		blur: "focusout"
	}, function(a, b) {
		var c = function(a) {
			n.event.simulate(b, a.target, n.event.fix(a), !0)
		};
		n.event.special[b] = {
			setup: function() {
				var d = this.ownerDocument || this,
					e = L.access(d, b);
				e || d.addEventListener(a, c, !0), L.access(d, b, (e || 0) + 1)
			},
			teardown: function() {
				var d = this.ownerDocument || this,
					e = L.access(d, b) - 1;
				e ? L.access(d, b, e) : (d.removeEventListener(a, c, !0), L.remove(d, b))
			}
		}
	}), n.fn.extend({
		on: function(a, b, c, d, e) {
			var f, g;
			if("object" == typeof a) {
				"string" != typeof b && (c = c || b, b = void 0);
				for(g in a) this.on(g, b, c, a[g], e);
				return this
			}
			if(null == c && null == d ? (d = b, c = b = void 0) : null == d && ("string" == typeof b ? (d = c, c = void 0) : (d = c, c = b, b = void 0)), d === !1) d = $;
			else if(!d) return this;
			return 1 === e && (f = d, d = function(a) {
				return n().off(a), f.apply(this, arguments)
			}, d.guid = f.guid || (f.guid = n.guid++)), this.each(function() {
				n.event.add(this, a, d, c, b)
			})
		},
		one: function(a, b, c, d) {
			return this.on(a, b, c, d, 1)
		},
		off: function(a, b, c) {
			var d, e;
			if(a && a.preventDefault && a.handleObj) return d = a.handleObj, n(a.delegateTarget).off(d.namespace ? d.origType + "." + d.namespace : d.origType, d.selector, d.handler), this;
			if("object" == typeof a) {
				for(e in a) this.off(e, b, a[e]);
				return this
			}
			return(b === !1 || "function" == typeof b) && (c = b, b = void 0), c === !1 && (c = $), this.each(function() {
				n.event.remove(this, a, c, b)
			})
		},
		trigger: function(a, b) {
			return this.each(function() {
				n.event.trigger(a, b, this)
			})
		},
		triggerHandler: function(a, b) {
			var c = this[0];
			return c ? n.event.trigger(a, b, c, !0) : void 0
		}
	});
	var aa = /<(?!area|br|col|embed|hr|img|input|link|meta|param)(([\w:]+)[^>]*)\/>/gi,
		ba = /<([\w:]+)/,
		ca = /<|&#?\w+;/,
		da = /<(?:script|style|link)/i,
		ea = /checked\s*(?:[^=]|=\s*.checked.)/i,
		fa = /^$|\/(?:java|ecma)script/i,
		ga = /^true\/(.*)/,
		ha = /^\s*<!(?:\[CDATA\[|--)|(?:\]\]|--)>\s*$/g,
		ia = {
			option: [1, "<select multiple='multiple'>", "</select>"],
			thead: [1, "<table>", "</table>"],
			col: [2, "<table><colgroup>", "</colgroup></table>"],
			tr: [2, "<table><tbody>", "</tbody></table>"],
			td: [3, "<table><tbody><tr>", "</tr></tbody></table>"],
			_default: [0, "", ""]
		};
	ia.optgroup = ia.option, ia.tbody = ia.tfoot = ia.colgroup = ia.caption = ia.thead, ia.th = ia.td;

	function ja(a, b) {
		return n.nodeName(a, "table") && n.nodeName(11 !== b.nodeType ? b : b.firstChild, "tr") ? a.getElementsByTagName("tbody")[0] || a.appendChild(a.ownerDocument.createElement("tbody")) : a
	}

	function ka(a) {
		return a.type = (null !== a.getAttribute("type")) + "/" + a.type, a
	}

	function la(a) {
		var b = ga.exec(a.type);
		return b ? a.type = b[1] : a.removeAttribute("type"), a
	}

	function ma(a, b) {
		for(var c = 0, d = a.length; d > c; c++) L.set(a[c], "globalEval", !b || L.get(b[c], "globalEval"))
	}

	function na(a, b) {
		var c, d, e, f, g, h, i, j;
		if(1 === b.nodeType) {
			if(L.hasData(a) && (f = L.access(a), g = L.set(b, f), j = f.events)) {
				delete g.handle, g.events = {};
				for(e in j)
					for(c = 0, d = j[e].length; d > c; c++) n.event.add(b, e, j[e][c])
			}
			M.hasData(a) && (h = M.access(a), i = n.extend({}, h), M.set(b, i))
		}
	}

	function oa(a, b) {
		var c = a.getElementsByTagName ? a.getElementsByTagName(b || "*") : a.querySelectorAll ? a.querySelectorAll(b || "*") : [];
		return void 0 === b || b && n.nodeName(a, b) ? n.merge([a], c) : c
	}

	function pa(a, b) {
		var c = b.nodeName.toLowerCase();
		"input" === c && T.test(a.type) ? b.checked = a.checked : ("input" === c || "textarea" === c) && (b.defaultValue = a.defaultValue)
	}
	n.extend({
		clone: function(a, b, c) {
			var d, e, f, g, h = a.cloneNode(!0),
				i = n.contains(a.ownerDocument, a);
			if(!(k.noCloneChecked || 1 !== a.nodeType && 11 !== a.nodeType || n.isXMLDoc(a)))
				for(g = oa(h), f = oa(a), d = 0, e = f.length; e > d; d++) pa(f[d], g[d]);
			if(b)
				if(c)
					for(f = f || oa(a), g = g || oa(h), d = 0, e = f.length; e > d; d++) na(f[d], g[d]);
				else na(a, h);
			return g = oa(h, "script"), g.length > 0 && ma(g, !i && oa(a, "script")), h
		},
		buildFragment: function(a, b, c, d) {
			for(var e, f, g, h, i, j, k = b.createDocumentFragment(), l = [], m = 0, o = a.length; o > m; m++)
				if(e = a[m], e || 0 === e)
					if("object" === n.type(e)) n.merge(l, e.nodeType ? [e] : e);
					else if(ca.test(e)) {
				f = f || k.appendChild(b.createElement("div")), g = (ba.exec(e) || ["", ""])[1].toLowerCase(), h = ia[g] || ia._default, f.innerHTML = h[1] + e.replace(aa, "<$1></$2>") + h[2], j = h[0];
				while(j--) f = f.lastChild;
				n.merge(l, f.childNodes), f = k.firstChild, f.textContent = ""
			} else l.push(b.createTextNode(e));
			k.textContent = "", m = 0;
			while(e = l[m++])
				if((!d || -1 === n.inArray(e, d)) && (i = n.contains(e.ownerDocument, e), f = oa(k.appendChild(e), "script"), i && ma(f), c)) {
					j = 0;
					while(e = f[j++]) fa.test(e.type || "") && c.push(e)
				}
			return k
		},
		cleanData: function(a) {
			for(var b, c, d, e, f = n.event.special, g = 0; void 0 !== (c = a[g]); g++) {
				if(n.acceptData(c) && (e = c[L.expando], e && (b = L.cache[e]))) {
					if(b.events)
						for(d in b.events) f[d] ? n.event.remove(c, d) : n.removeEvent(c, d, b.handle);
					L.cache[e] && delete L.cache[e]
				}
				delete M.cache[c[M.expando]]
			}
		}
	}), n.fn.extend({
		text: function(a) {
			return J(this, function(a) {
				return void 0 === a ? n.text(this) : this.empty().each(function() {
					(1 === this.nodeType || 11 === this.nodeType || 9 === this.nodeType) && (this.textContent = a)
				})
			}, null, a, arguments.length)
		},
		append: function() {
			return this.domManip(arguments, function(a) {
				if(1 === this.nodeType || 11 === this.nodeType || 9 === this.nodeType) {
					var b = ja(this, a);
					b.appendChild(a)
				}
			})
		},
		prepend: function() {
			return this.domManip(arguments, function(a) {
				if(1 === this.nodeType || 11 === this.nodeType || 9 === this.nodeType) {
					var b = ja(this, a);
					b.insertBefore(a, b.firstChild)
				}
			})
		},
		before: function() {
			return this.domManip(arguments, function(a) {
				this.parentNode && this.parentNode.insertBefore(a, this)
			})
		},
		after: function() {
			return this.domManip(arguments, function(a) {
				this.parentNode && this.parentNode.insertBefore(a, this.nextSibling)
			})
		},
		remove: function(a, b) {
			for(var c, d = a ? n.filter(a, this) : this, e = 0; null != (c = d[e]); e++) b || 1 !== c.nodeType || n.cleanData(oa(c)), c.parentNode && (b && n.contains(c.ownerDocument, c) && ma(oa(c, "script")), c.parentNode.removeChild(c));
			return this
		},
		empty: function() {
			for(var a, b = 0; null != (a = this[b]); b++) 1 === a.nodeType && (n.cleanData(oa(a, !1)), a.textContent = "");
			return this
		},
		clone: function(a, b) {
			return a = null == a ? !1 : a, b = null == b ? a : b, this.map(function() {
				return n.clone(this, a, b)
			})
		},
		html: function(a) {
			return J(this, function(a) {
				var b = this[0] || {},
					c = 0,
					d = this.length;
				if(void 0 === a && 1 === b.nodeType) return b.innerHTML;
				if("string" == typeof a && !da.test(a) && !ia[(ba.exec(a) || ["", ""])[1].toLowerCase()]) {
					a = a.replace(aa, "<$1></$2>");
					try {
						for(; d > c; c++) b = this[c] || {}, 1 === b.nodeType && (n.cleanData(oa(b, !1)), b.innerHTML = a);
						b = 0
					} catch(e) {}
				}
				b && this.empty().append(a)
			}, null, a, arguments.length)
		},
		replaceWith: function() {
			var a = arguments[0];
			return this.domManip(arguments, function(b) {
				a = this.parentNode, n.cleanData(oa(this)), a && a.replaceChild(b, this)
			}), a && (a.length || a.nodeType) ? this : this.remove()
		},
		detach: function(a) {
			return this.remove(a, !0)
		},
		domManip: function(a, b) {
			a = e.apply([], a);
			var c, d, f, g, h, i, j = 0,
				l = this.length,
				m = this,
				o = l - 1,
				p = a[0],
				q = n.isFunction(p);
			if(q || l > 1 && "string" == typeof p && !k.checkClone && ea.test(p)) return this.each(function(c) {
				var d = m.eq(c);
				q && (a[0] = p.call(this, c, d.html())), d.domManip(a, b)
			});
			if(l && (c = n.buildFragment(a, this[0].ownerDocument, !1, this), d = c.firstChild, 1 === c.childNodes.length && (c = d), d)) {
				for(f = n.map(oa(c, "script"), ka), g = f.length; l > j; j++) h = c, j !== o && (h = n.clone(h, !0, !0), g && n.merge(f, oa(h, "script"))), b.call(this[j], h, j);
				if(g)
					for(i = f[f.length - 1].ownerDocument, n.map(f, la), j = 0; g > j; j++) h = f[j], fa.test(h.type || "") && !L.access(h, "globalEval") && n.contains(i, h) && (h.src ? n._evalUrl && n._evalUrl(h.src) : n.globalEval(h.textContent.replace(ha, "")))
			}
			return this
		}
	}), n.each({
		appendTo: "append",
		prependTo: "prepend",
		insertBefore: "before",
		insertAfter: "after",
		replaceAll: "replaceWith"
	}, function(a, b) {
		n.fn[a] = function(a) {
			for(var c, d = [], e = n(a), g = e.length - 1, h = 0; g >= h; h++) c = h === g ? this : this.clone(!0), n(e[h])[b](c), f.apply(d, c.get());
			return this.pushStack(d)
		}
	});
	var qa, ra = {};

	function sa(b, c) {
		var d, e = n(c.createElement(b)).appendTo(c.body),
			f = a.getDefaultComputedStyle && (d = a.getDefaultComputedStyle(e[0])) ? d.display : n.css(e[0], "display");
		return e.detach(), f
	}

	function ta(a) {
		var b = l,
			c = ra[a];
		return c || (c = sa(a, b), "none" !== c && c || (qa = (qa || n("<iframe frameborder='0' width='0' height='0'/>")).appendTo(b.documentElement), b = qa[0].contentDocument, b.write(), b.close(), c = sa(a, b), qa.detach()), ra[a] = c), c
	}
	var ua = /^margin/,
		va = new RegExp("^(" + Q + ")(?!px)[a-z%]+$", "i"),
		wa = function(b) {
			return b.ownerDocument.defaultView.opener ? b.ownerDocument.defaultView.getComputedStyle(b, null) : a.getComputedStyle(b, null)
		};

	function xa(a, b, c) {
		var d, e, f, g, h = a.style;
		return c = c || wa(a), c && (g = c.getPropertyValue(b) || c[b]), c && ("" !== g || n.contains(a.ownerDocument, a) || (g = n.style(a, b)), va.test(g) && ua.test(b) && (d = h.width, e = h.minWidth, f = h.maxWidth, h.minWidth = h.maxWidth = h.width = g, g = c.width, h.width = d, h.minWidth = e, h.maxWidth = f)), void 0 !== g ? g + "" : g
	}

	function ya(a, b) {
		return {
			get: function() {
				return a() ? void delete this.get : (this.get = b).apply(this, arguments)
			}
		}
	}! function() {
		var b, c, d = l.documentElement,
			e = l.createElement("div"),
			f = l.createElement("div");
		if(f.style) {
			f.style.backgroundClip = "content-box", f.cloneNode(!0).style.backgroundClip = "", k.clearCloneStyle = "content-box" === f.style.backgroundClip, e.style.cssText = "border:0;width:0;height:0;top:0;left:-9999px;margin-top:1px;position:absolute", e.appendChild(f);

			function g() {
				f.style.cssText = "-webkit-box-sizing:border-box;-moz-box-sizing:border-box;box-sizing:border-box;display:block;margin-top:1%;top:1%;border:1px;padding:1px;width:4px;position:absolute", f.innerHTML = "", d.appendChild(e);
				var g = a.getComputedStyle(f, null);
				b = "1%" !== g.top, c = "4px" === g.width, d.removeChild(e)
			}
			a.getComputedStyle && n.extend(k, {
				pixelPosition: function() {
					return g(), b
				},
				boxSizingReliable: function() {
					return null == c && g(), c
				},
				reliableMarginRight: function() {
					var b, c = f.appendChild(l.createElement("div"));
					return c.style.cssText = f.style.cssText = "-webkit-box-sizing:content-box;-moz-box-sizing:content-box;box-sizing:content-box;display:block;margin:0;border:0;padding:0", c.style.marginRight = c.style.width = "0", f.style.width = "1px", d.appendChild(e), b = !parseFloat(a.getComputedStyle(c, null).marginRight), d.removeChild(e), f.removeChild(c), b
				}
			})
		}
	}(), n.swap = function(a, b, c, d) {
		var e, f, g = {};
		for(f in b) g[f] = a.style[f], a.style[f] = b[f];
		e = c.apply(a, d || []);
		for(f in b) a.style[f] = g[f];
		return e
	};
	var za = /^(none|table(?!-c[ea]).+)/,
		Aa = new RegExp("^(" + Q + ")(.*)$", "i"),
		Ba = new RegExp("^([+-])=(" + Q + ")", "i"),
		Ca = {
			position: "absolute",
			visibility: "hidden",
			display: "block"
		},
		Da = {
			letterSpacing: "0",
			fontWeight: "400"
		},
		Ea = ["Webkit", "O", "Moz", "ms"];

	function Fa(a, b) {
		if(b in a) return b;
		var c = b[0].toUpperCase() + b.slice(1),
			d = b,
			e = Ea.length;
		while(e--)
			if(b = Ea[e] + c, b in a) return b;
		return d
	}

	function Ga(a, b, c) {
		var d = Aa.exec(b);
		return d ? Math.max(0, d[1] - (c || 0)) + (d[2] || "px") : b
	}

	function Ha(a, b, c, d, e) {
		for(var f = c === (d ? "border" : "content") ? 4 : "width" === b ? 1 : 0, g = 0; 4 > f; f += 2) "margin" === c && (g += n.css(a, c + R[f], !0, e)), d ? ("content" === c && (g -= n.css(a, "padding" + R[f], !0, e)), "margin" !== c && (g -= n.css(a, "border" + R[f] + "Width", !0, e))) : (g += n.css(a, "padding" + R[f], !0, e), "padding" !== c && (g += n.css(a, "border" + R[f] + "Width", !0, e)));
		return g
	}

	function Ia(a, b, c) {
		var d = !0,
			e = "width" === b ? a.offsetWidth : a.offsetHeight,
			f = wa(a),
			g = "border-box" === n.css(a, "boxSizing", !1, f);
		if(0 >= e || null == e) {
			if(e = xa(a, b, f), (0 > e || null == e) && (e = a.style[b]), va.test(e)) return e;
			d = g && (k.boxSizingReliable() || e === a.style[b]), e = parseFloat(e) || 0
		}
		return e + Ha(a, b, c || (g ? "border" : "content"), d, f) + "px"
	}

	function Ja(a, b) {
		for(var c, d, e, f = [], g = 0, h = a.length; h > g; g++) d = a[g], d.style && (f[g] = L.get(d, "olddisplay"), c = d.style.display, b ? (f[g] || "none" !== c || (d.style.display = ""), "" === d.style.display && S(d) && (f[g] = L.access(d, "olddisplay", ta(d.nodeName)))) : (e = S(d), "none" === c && e || L.set(d, "olddisplay", e ? c : n.css(d, "display"))));
		for(g = 0; h > g; g++) d = a[g], d.style && (b && "none" !== d.style.display && "" !== d.style.display || (d.style.display = b ? f[g] || "" : "none"));
		return a
	}
	n.extend({
		cssHooks: {
			opacity: {
				get: function(a, b) {
					if(b) {
						var c = xa(a, "opacity");
						return "" === c ? "1" : c
					}
				}
			}
		},
		cssNumber: {
			columnCount: !0,
			fillOpacity: !0,
			flexGrow: !0,
			flexShrink: !0,
			fontWeight: !0,
			lineHeight: !0,
			opacity: !0,
			order: !0,
			orphans: !0,
			widows: !0,
			zIndex: !0,
			zoom: !0
		},
		cssProps: {
			"float": "cssFloat"
		},
		style: function(a, b, c, d) {
			if(a && 3 !== a.nodeType && 8 !== a.nodeType && a.style) {
				var e, f, g, h = n.camelCase(b),
					i = a.style;
				return b = n.cssProps[h] || (n.cssProps[h] = Fa(i, h)), g = n.cssHooks[b] || n.cssHooks[h], void 0 === c ? g && "get" in g && void 0 !== (e = g.get(a, !1, d)) ? e : i[b] : (f = typeof c, "string" === f && (e = Ba.exec(c)) && (c = (e[1] + 1) * e[2] + parseFloat(n.css(a, b)), f = "number"), null != c && c === c && ("number" !== f || n.cssNumber[h] || (c += "px"), k.clearCloneStyle || "" !== c || 0 !== b.indexOf("background") || (i[b] = "inherit"), g && "set" in g && void 0 === (c = g.set(a, c, d)) || (i[b] = c)), void 0)
			}
		},
		css: function(a, b, c, d) {
			var e, f, g, h = n.camelCase(b);
			return b = n.cssProps[h] || (n.cssProps[h] = Fa(a.style, h)), g = n.cssHooks[b] || n.cssHooks[h], g && "get" in g && (e = g.get(a, !0, c)), void 0 === e && (e = xa(a, b, d)), "normal" === e && b in Da && (e = Da[b]), "" === c || c ? (f = parseFloat(e), c === !0 || n.isNumeric(f) ? f || 0 : e) : e
		}
	}), n.each(["height", "width"], function(a, b) {
		n.cssHooks[b] = {
			get: function(a, c, d) {
				return c ? za.test(n.css(a, "display")) && 0 === a.offsetWidth ? n.swap(a, Ca, function() {
					return Ia(a, b, d)
				}) : Ia(a, b, d) : void 0
			},
			set: function(a, c, d) {
				var e = d && wa(a);
				return Ga(a, c, d ? Ha(a, b, d, "border-box" === n.css(a, "boxSizing", !1, e), e) : 0)
			}
		}
	}), n.cssHooks.marginRight = ya(k.reliableMarginRight, function(a, b) {
		return b ? n.swap(a, {
			display: "inline-block"
		}, xa, [a, "marginRight"]) : void 0
	}), n.each({
		margin: "",
		padding: "",
		border: "Width"
	}, function(a, b) {
		n.cssHooks[a + b] = {
			expand: function(c) {
				for(var d = 0, e = {}, f = "string" == typeof c ? c.split(" ") : [c]; 4 > d; d++) e[a + R[d] + b] = f[d] || f[d - 2] || f[0];
				return e
			}
		}, ua.test(a) || (n.cssHooks[a + b].set = Ga)
	}), n.fn.extend({
		css: function(a, b) {
			return J(this, function(a, b, c) {
				var d, e, f = {},
					g = 0;
				if(n.isArray(b)) {
					for(d = wa(a), e = b.length; e > g; g++) f[b[g]] = n.css(a, b[g], !1, d);
					return f
				}
				return void 0 !== c ? n.style(a, b, c) : n.css(a, b)
			}, a, b, arguments.length > 1)
		},
		show: function() {
			return Ja(this, !0)
		},
		hide: function() {
			return Ja(this)
		},
		toggle: function(a) {
			return "boolean" == typeof a ? a ? this.show() : this.hide() : this.each(function() {
				S(this) ? n(this).show() : n(this).hide()
			})
		}
	});

	function Ka(a, b, c, d, e) {
		return new Ka.prototype.init(a, b, c, d, e)
	}
	n.Tween = Ka, Ka.prototype = {
		constructor: Ka,
		init: function(a, b, c, d, e, f) {
			this.elem = a, this.prop = c, this.easing = e || "swing", this.options = b, this.start = this.now = this.cur(), this.end = d, this.unit = f || (n.cssNumber[c] ? "" : "px")
		},
		cur: function() {
			var a = Ka.propHooks[this.prop];
			return a && a.get ? a.get(this) : Ka.propHooks._default.get(this)
		},
		run: function(a) {
			var b, c = Ka.propHooks[this.prop];
			return this.options.duration ? this.pos = b = n.easing[this.easing](a, this.options.duration * a, 0, 1, this.options.duration) : this.pos = b = a, this.now = (this.end - this.start) * b + this.start, this.options.step && this.options.step.call(this.elem, this.now, this), c && c.set ? c.set(this) : Ka.propHooks._default.set(this), this
		}
	}, Ka.prototype.init.prototype = Ka.prototype, Ka.propHooks = {
		_default: {
			get: function(a) {
				var b;
				return null == a.elem[a.prop] || a.elem.style && null != a.elem.style[a.prop] ? (b = n.css(a.elem, a.prop, ""), b && "auto" !== b ? b : 0) : a.elem[a.prop]
			},
			set: function(a) {
				n.fx.step[a.prop] ? n.fx.step[a.prop](a) : a.elem.style && (null != a.elem.style[n.cssProps[a.prop]] || n.cssHooks[a.prop]) ? n.style(a.elem, a.prop, a.now + a.unit) : a.elem[a.prop] = a.now
			}
		}
	}, Ka.propHooks.scrollTop = Ka.propHooks.scrollLeft = {
		set: function(a) {
			a.elem.nodeType && a.elem.parentNode && (a.elem[a.prop] = a.now)
		}
	}, n.easing = {
		linear: function(a) {
			return a
		},
		swing: function(a) {
			return .5 - Math.cos(a * Math.PI) / 2
		}
	}, n.fx = Ka.prototype.init, n.fx.step = {};
	var La, Ma, Na = /^(?:toggle|show|hide)$/,
		Oa = new RegExp("^(?:([+-])=|)(" + Q + ")([a-z%]*)$", "i"),
		Pa = /queueHooks$/,
		Qa = [Va],
		Ra = {
			"*": [function(a, b) {
				var c = this.createTween(a, b),
					d = c.cur(),
					e = Oa.exec(b),
					f = e && e[3] || (n.cssNumber[a] ? "" : "px"),
					g = (n.cssNumber[a] || "px" !== f && +d) && Oa.exec(n.css(c.elem, a)),
					h = 1,
					i = 20;
				if(g && g[3] !== f) {
					f = f || g[3], e = e || [], g = +d || 1;
					do h = h || ".5", g /= h, n.style(c.elem, a, g + f); while (h !== (h = c.cur() / d) && 1 !== h && --i)
				}
				return e && (g = c.start = +g || +d || 0, c.unit = f, c.end = e[1] ? g + (e[1] + 1) * e[2] : +e[2]), c
			}]
		};

	function Sa() {
		return setTimeout(function() {
			La = void 0
		}), La = n.now()
	}

	function Ta(a, b) {
		var c, d = 0,
			e = {
				height: a
			};
		for(b = b ? 1 : 0; 4 > d; d += 2 - b) c = R[d], e["margin" + c] = e["padding" + c] = a;
		return b && (e.opacity = e.width = a), e
	}

	function Ua(a, b, c) {
		for(var d, e = (Ra[b] || []).concat(Ra["*"]), f = 0, g = e.length; g > f; f++)
			if(d = e[f].call(c, b, a)) return d
	}

	function Va(a, b, c) {
		var d, e, f, g, h, i, j, k, l = this,
			m = {},
			o = a.style,
			p = a.nodeType && S(a),
			q = L.get(a, "fxshow");
		c.queue || (h = n._queueHooks(a, "fx"), null == h.unqueued && (h.unqueued = 0, i = h.empty.fire, h.empty.fire = function() {
			h.unqueued || i()
		}), h.unqueued++, l.always(function() {
			l.always(function() {
				h.unqueued--, n.queue(a, "fx").length || h.empty.fire()
			})
		})), 1 === a.nodeType && ("height" in b || "width" in b) && (c.overflow = [o.overflow, o.overflowX, o.overflowY], j = n.css(a, "display"), k = "none" === j ? L.get(a, "olddisplay") || ta(a.nodeName) : j, "inline" === k && "none" === n.css(a, "float") && (o.display = "inline-block")), c.overflow && (o.overflow = "hidden", l.always(function() {
			o.overflow = c.overflow[0], o.overflowX = c.overflow[1], o.overflowY = c.overflow[2]
		}));
		for(d in b)
			if(e = b[d], Na.exec(e)) {
				if(delete b[d], f = f || "toggle" === e, e === (p ? "hide" : "show")) {
					if("show" !== e || !q || void 0 === q[d]) continue;
					p = !0
				}
				m[d] = q && q[d] || n.style(a, d)
			} else j = void 0;
		if(n.isEmptyObject(m)) "inline" === ("none" === j ? ta(a.nodeName) : j) && (o.display = j);
		else {
			q ? "hidden" in q && (p = q.hidden) : q = L.access(a, "fxshow", {}), f && (q.hidden = !p), p ? n(a).show() : l.done(function() {
				n(a).hide()
			}), l.done(function() {
				var b;
				L.remove(a, "fxshow");
				for(b in m) n.style(a, b, m[b])
			});
			for(d in m) g = Ua(p ? q[d] : 0, d, l), d in q || (q[d] = g.start, p && (g.end = g.start, g.start = "width" === d || "height" === d ? 1 : 0))
		}
	}

	function Wa(a, b) {
		var c, d, e, f, g;
		for(c in a)
			if(d = n.camelCase(c), e = b[d], f = a[c], n.isArray(f) && (e = f[1], f = a[c] = f[0]), c !== d && (a[d] = f, delete a[c]), g = n.cssHooks[d], g && "expand" in g) {
				f = g.expand(f), delete a[d];
				for(c in f) c in a || (a[c] = f[c], b[c] = e)
			} else b[d] = e
	}

	function Xa(a, b, c) {
		var d, e, f = 0,
			g = Qa.length,
			h = n.Deferred().always(function() {
				delete i.elem
			}),
			i = function() {
				if(e) return !1;
				for(var b = La || Sa(), c = Math.max(0, j.startTime + j.duration - b), d = c / j.duration || 0, f = 1 - d, g = 0, i = j.tweens.length; i > g; g++) j.tweens[g].run(f);
				return h.notifyWith(a, [j, f, c]), 1 > f && i ? c : (h.resolveWith(a, [j]), !1)
			},
			j = h.promise({
				elem: a,
				props: n.extend({}, b),
				opts: n.extend(!0, {
					specialEasing: {}
				}, c),
				originalProperties: b,
				originalOptions: c,
				startTime: La || Sa(),
				duration: c.duration,
				tweens: [],
				createTween: function(b, c) {
					var d = n.Tween(a, j.opts, b, c, j.opts.specialEasing[b] || j.opts.easing);
					return j.tweens.push(d), d
				},
				stop: function(b) {
					var c = 0,
						d = b ? j.tweens.length : 0;
					if(e) return this;
					for(e = !0; d > c; c++) j.tweens[c].run(1);
					return b ? h.resolveWith(a, [j, b]) : h.rejectWith(a, [j, b]), this
				}
			}),
			k = j.props;
		for(Wa(k, j.opts.specialEasing); g > f; f++)
			if(d = Qa[f].call(j, a, k, j.opts)) return d;
		return n.map(k, Ua, j), n.isFunction(j.opts.start) && j.opts.start.call(a, j), n.fx.timer(n.extend(i, {
			elem: a,
			anim: j,
			queue: j.opts.queue
		})), j.progress(j.opts.progress).done(j.opts.done, j.opts.complete).fail(j.opts.fail).always(j.opts.always)
	}
	n.Animation = n.extend(Xa, {
			tweener: function(a, b) {
				n.isFunction(a) ? (b = a, a = ["*"]) : a = a.split(" ");
				for(var c, d = 0, e = a.length; e > d; d++) c = a[d], Ra[c] = Ra[c] || [], Ra[c].unshift(b)
			},
			prefilter: function(a, b) {
				b ? Qa.unshift(a) : Qa.push(a)
			}
		}), n.speed = function(a, b, c) {
			var d = a && "object" == typeof a ? n.extend({}, a) : {
				complete: c || !c && b || n.isFunction(a) && a,
				duration: a,
				easing: c && b || b && !n.isFunction(b) && b
			};
			return d.duration = n.fx.off ? 0 : "number" == typeof d.duration ? d.duration : d.duration in n.fx.speeds ? n.fx.speeds[d.duration] : n.fx.speeds._default, (null == d.queue || d.queue === !0) && (d.queue = "fx"), d.old = d.complete, d.complete = function() {
				n.isFunction(d.old) && d.old.call(this), d.queue && n.dequeue(this, d.queue)
			}, d
		}, n.fn.extend({
			fadeTo: function(a, b, c, d) {
				return this.filter(S).css("opacity", 0).show().end().animate({
					opacity: b
				}, a, c, d)
			},
			animate: function(a, b, c, d) {
				var e = n.isEmptyObject(a),
					f = n.speed(b, c, d),
					g = function() {
						var b = Xa(this, n.extend({}, a), f);
						(e || L.get(this, "finish")) && b.stop(!0)
					};
				return g.finish = g, e || f.queue === !1 ? this.each(g) : this.queue(f.queue, g)
			},
			stop: function(a, b, c) {
				var d = function(a) {
					var b = a.stop;
					delete a.stop, b(c)
				};
				return "string" != typeof a && (c = b, b = a, a = void 0), b && a !== !1 && this.queue(a || "fx", []), this.each(function() {
					var b = !0,
						e = null != a && a + "queueHooks",
						f = n.timers,
						g = L.get(this);
					if(e) g[e] && g[e].stop && d(g[e]);
					else
						for(e in g) g[e] && g[e].stop && Pa.test(e) && d(g[e]);
					for(e = f.length; e--;) f[e].elem !== this || null != a && f[e].queue !== a || (f[e].anim.stop(c), b = !1, f.splice(e, 1));
					(b || !c) && n.dequeue(this, a)
				})
			},
			finish: function(a) {
				return a !== !1 && (a = a || "fx"), this.each(function() {
					var b, c = L.get(this),
						d = c[a + "queue"],
						e = c[a + "queueHooks"],
						f = n.timers,
						g = d ? d.length : 0;
					for(c.finish = !0, n.queue(this, a, []), e && e.stop && e.stop.call(this, !0), b = f.length; b--;) f[b].elem === this && f[b].queue === a && (f[b].anim.stop(!0), f.splice(b, 1));
					for(b = 0; g > b; b++) d[b] && d[b].finish && d[b].finish.call(this);
					delete c.finish
				})
			}
		}), n.each(["toggle", "show", "hide"], function(a, b) {
			var c = n.fn[b];
			n.fn[b] = function(a, d, e) {
				return null == a || "boolean" == typeof a ? c.apply(this, arguments) : this.animate(Ta(b, !0), a, d, e)
			}
		}), n.each({
			slideDown: Ta("show"),
			slideUp: Ta("hide"),
			slideToggle: Ta("toggle"),
			fadeIn: {
				opacity: "show"
			},
			fadeOut: {
				opacity: "hide"
			},
			fadeToggle: {
				opacity: "toggle"
			}
		}, function(a, b) {
			n.fn[a] = function(a, c, d) {
				return this.animate(b, a, c, d)
			}
		}), n.timers = [], n.fx.tick = function() {
			var a, b = 0,
				c = n.timers;
			for(La = n.now(); b < c.length; b++) a = c[b], a() || c[b] !== a || c.splice(b--, 1);
			c.length || n.fx.stop(), La = void 0
		}, n.fx.timer = function(a) {
			n.timers.push(a), a() ? n.fx.start() : n.timers.pop()
		}, n.fx.interval = 13, n.fx.start = function() {
			Ma || (Ma = setInterval(n.fx.tick, n.fx.interval))
		}, n.fx.stop = function() {
			clearInterval(Ma), Ma = null
		}, n.fx.speeds = {
			slow: 600,
			fast: 200,
			_default: 400
		}, n.fn.delay = function(a, b) {
			return a = n.fx ? n.fx.speeds[a] || a : a, b = b || "fx", this.queue(b, function(b, c) {
				var d = setTimeout(b, a);
				c.stop = function() {
					clearTimeout(d)
				}
			})
		},
		function() {
			var a = l.createElement("input"),
				b = l.createElement("select"),
				c = b.appendChild(l.createElement("option"));
			a.type = "checkbox", k.checkOn = "" !== a.value, k.optSelected = c.selected, b.disabled = !0, k.optDisabled = !c.disabled, a = l.createElement("input"), a.value = "t", a.type = "radio", k.radioValue = "t" === a.value
		}();
	var Ya, Za, $a = n.expr.attrHandle;
	n.fn.extend({
		attr: function(a, b) {
			return J(this, n.attr, a, b, arguments.length > 1)
		},
		removeAttr: function(a) {
			return this.each(function() {
				n.removeAttr(this, a)
			})
		}
	}), n.extend({
		attr: function(a, b, c) {
			var d, e, f = a.nodeType;
			if(a && 3 !== f && 8 !== f && 2 !== f) return typeof a.getAttribute === U ? n.prop(a, b, c) : (1 === f && n.isXMLDoc(a) || (b = b.toLowerCase(), d = n.attrHooks[b] || (n.expr.match.bool.test(b) ? Za : Ya)),
				void 0 === c ? d && "get" in d && null !== (e = d.get(a, b)) ? e : (e = n.find.attr(a, b), null == e ? void 0 : e) : null !== c ? d && "set" in d && void 0 !== (e = d.set(a, c, b)) ? e : (a.setAttribute(b, c + ""), c) : void n.removeAttr(a, b))
		},
		removeAttr: function(a, b) {
			var c, d, e = 0,
				f = b && b.match(E);
			if(f && 1 === a.nodeType)
				while(c = f[e++]) d = n.propFix[c] || c, n.expr.match.bool.test(c) && (a[d] = !1), a.removeAttribute(c)
		},
		attrHooks: {
			type: {
				set: function(a, b) {
					if(!k.radioValue && "radio" === b && n.nodeName(a, "input")) {
						var c = a.value;
						return a.setAttribute("type", b), c && (a.value = c), b
					}
				}
			}
		}
	}), Za = {
		set: function(a, b, c) {
			return b === !1 ? n.removeAttr(a, c) : a.setAttribute(c, c), c
		}
	}, n.each(n.expr.match.bool.source.match(/\w+/g), function(a, b) {
		var c = $a[b] || n.find.attr;
		$a[b] = function(a, b, d) {
			var e, f;
			return d || (f = $a[b], $a[b] = e, e = null != c(a, b, d) ? b.toLowerCase() : null, $a[b] = f), e
		}
	});
	var _a = /^(?:input|select|textarea|button)$/i;
	n.fn.extend({
		prop: function(a, b) {
			return J(this, n.prop, a, b, arguments.length > 1)
		},
		removeProp: function(a) {
			return this.each(function() {
				delete this[n.propFix[a] || a]
			})
		}
	}), n.extend({
		propFix: {
			"for": "htmlFor",
			"class": "className"
		},
		prop: function(a, b, c) {
			var d, e, f, g = a.nodeType;
			if(a && 3 !== g && 8 !== g && 2 !== g) return f = 1 !== g || !n.isXMLDoc(a), f && (b = n.propFix[b] || b, e = n.propHooks[b]), void 0 !== c ? e && "set" in e && void 0 !== (d = e.set(a, c, b)) ? d : a[b] = c : e && "get" in e && null !== (d = e.get(a, b)) ? d : a[b]
		},
		propHooks: {
			tabIndex: {
				get: function(a) {
					return a.hasAttribute("tabindex") || _a.test(a.nodeName) || a.href ? a.tabIndex : -1
				}
			}
		}
	}), k.optSelected || (n.propHooks.selected = {
		get: function(a) {
			var b = a.parentNode;
			return b && b.parentNode && b.parentNode.selectedIndex, null
		}
	}), n.each(["tabIndex", "readOnly", "maxLength", "cellSpacing", "cellPadding", "rowSpan", "colSpan", "useMap", "frameBorder", "contentEditable"], function() {
		n.propFix[this.toLowerCase()] = this
	});
	var ab = /[\t\r\n\f]/g;
	n.fn.extend({
		addClass: function(a) {
			var b, c, d, e, f, g, h = "string" == typeof a && a,
				i = 0,
				j = this.length;
			if(n.isFunction(a)) return this.each(function(b) {
				n(this).addClass(a.call(this, b, this.className))
			});
			if(h)
				for(b = (a || "").match(E) || []; j > i; i++)
					if(c = this[i], d = 1 === c.nodeType && (c.className ? (" " + c.className + " ").replace(ab, " ") : " ")) {
						f = 0;
						while(e = b[f++]) d.indexOf(" " + e + " ") < 0 && (d += e + " ");
						g = n.trim(d), c.className !== g && (c.className = g)
					}
			return this
		},
		removeClass: function(a) {
			var b, c, d, e, f, g, h = 0 === arguments.length || "string" == typeof a && a,
				i = 0,
				j = this.length;
			if(n.isFunction(a)) return this.each(function(b) {
				n(this).removeClass(a.call(this, b, this.className))
			});
			if(h)
				for(b = (a || "").match(E) || []; j > i; i++)
					if(c = this[i], d = 1 === c.nodeType && (c.className ? (" " + c.className + " ").replace(ab, " ") : "")) {
						f = 0;
						while(e = b[f++])
							while(d.indexOf(" " + e + " ") >= 0) d = d.replace(" " + e + " ", " ");
						g = a ? n.trim(d) : "", c.className !== g && (c.className = g)
					}
			return this
		},
		toggleClass: function(a, b) {
			var c = typeof a;
			return "boolean" == typeof b && "string" === c ? b ? this.addClass(a) : this.removeClass(a) : this.each(n.isFunction(a) ? function(c) {
				n(this).toggleClass(a.call(this, c, this.className, b), b)
			} : function() {
				if("string" === c) {
					var b, d = 0,
						e = n(this),
						f = a.match(E) || [];
					while(b = f[d++]) e.hasClass(b) ? e.removeClass(b) : e.addClass(b)
				} else(c === U || "boolean" === c) && (this.className && L.set(this, "__className__", this.className), this.className = this.className || a === !1 ? "" : L.get(this, "__className__") || "")
			})
		},
		hasClass: function(a) {
			for(var b = " " + a + " ", c = 0, d = this.length; d > c; c++)
				if(1 === this[c].nodeType && (" " + this[c].className + " ").replace(ab, " ").indexOf(b) >= 0) return !0;
			return !1
		}
	});
	var bb = /\r/g;
	n.fn.extend({
		val: function(a) {
			var b, c, d, e = this[0]; {
				if(arguments.length) return d = n.isFunction(a), this.each(function(c) {
					var e;
					1 === this.nodeType && (e = d ? a.call(this, c, n(this).val()) : a, null == e ? e = "" : "number" == typeof e ? e += "" : n.isArray(e) && (e = n.map(e, function(a) {
						return null == a ? "" : a + ""
					})), b = n.valHooks[this.type] || n.valHooks[this.nodeName.toLowerCase()], b && "set" in b && void 0 !== b.set(this, e, "value") || (this.value = e))
				});
				if(e) return b = n.valHooks[e.type] || n.valHooks[e.nodeName.toLowerCase()], b && "get" in b && void 0 !== (c = b.get(e, "value")) ? c : (c = e.value, "string" == typeof c ? c.replace(bb, "") : null == c ? "" : c)
			}
		}
	}), n.extend({
		valHooks: {
			option: {
				get: function(a) {
					var b = n.find.attr(a, "value");
					return null != b ? b : n.trim(n.text(a))
				}
			},
			select: {
				get: function(a) {
					for(var b, c, d = a.options, e = a.selectedIndex, f = "select-one" === a.type || 0 > e, g = f ? null : [], h = f ? e + 1 : d.length, i = 0 > e ? h : f ? e : 0; h > i; i++)
						if(c = d[i], !(!c.selected && i !== e || (k.optDisabled ? c.disabled : null !== c.getAttribute("disabled")) || c.parentNode.disabled && n.nodeName(c.parentNode, "optgroup"))) {
							if(b = n(c).val(), f) return b;
							g.push(b)
						}
					return g
				},
				set: function(a, b) {
					var c, d, e = a.options,
						f = n.makeArray(b),
						g = e.length;
					while(g--) d = e[g], (d.selected = n.inArray(d.value, f) >= 0) && (c = !0);
					return c || (a.selectedIndex = -1), f
				}
			}
		}
	}), n.each(["radio", "checkbox"], function() {
		n.valHooks[this] = {
			set: function(a, b) {
				return n.isArray(b) ? a.checked = n.inArray(n(a).val(), b) >= 0 : void 0
			}
		}, k.checkOn || (n.valHooks[this].get = function(a) {
			return null === a.getAttribute("value") ? "on" : a.value
		})
	}), n.each("blur focus focusin focusout load resize scroll unload click dblclick mousedown mouseup mousemove mouseover mouseout mouseenter mouseleave change select submit keydown keypress keyup error contextmenu".split(" "), function(a, b) {
		n.fn[b] = function(a, c) {
			return arguments.length > 0 ? this.on(b, null, a, c) : this.trigger(b)
		}
	}), n.fn.extend({
		hover: function(a, b) {
			return this.mouseenter(a).mouseleave(b || a)
		},
		bind: function(a, b, c) {
			return this.on(a, null, b, c)
		},
		unbind: function(a, b) {
			return this.off(a, null, b)
		},
		delegate: function(a, b, c, d) {
			return this.on(b, a, c, d)
		},
		undelegate: function(a, b, c) {
			return 1 === arguments.length ? this.off(a, "**") : this.off(b, a || "**", c)
		}
	});
	var cb = n.now(),
		db = /\?/;
	n.parseJSON = function(a) {
		return JSON.parse(a + "")
	}, n.parseXML = function(a) {
		var b, c;
		if(!a || "string" != typeof a) return null;
		try {
			c = new DOMParser, b = c.parseFromString(a, "text/xml")
		} catch(d) {
			b = void 0
		}
		return(!b || b.getElementsByTagName("parsererror").length) && n.error("Invalid XML: " + a), b
	};
	var eb = /#.*$/,
		fb = /([?&])_=[^&]*/,
		gb = /^(.*?):[ \t]*([^\r\n]*)$/gm,
		hb = /^(?:about|app|app-storage|.+-extension|file|res|widget):$/,
		ib = /^(?:GET|HEAD)$/,
		jb = /^\/\//,
		kb = /^([\w.+-]+:)(?:\/\/(?:[^\/?#]*@|)([^\/?#:]*)(?::(\d+)|)|)/,
		lb = {},
		mb = {},
		nb = "*/".concat("*"),
		ob = a.location.href,
		pb = kb.exec(ob.toLowerCase()) || [];

	function qb(a) {
		return function(b, c) {
			"string" != typeof b && (c = b, b = "*");
			var d, e = 0,
				f = b.toLowerCase().match(E) || [];
			if(n.isFunction(c))
				while(d = f[e++]) "+" === d[0] ? (d = d.slice(1) || "*", (a[d] = a[d] || []).unshift(c)) : (a[d] = a[d] || []).push(c)
		}
	}

	function rb(a, b, c, d) {
		var e = {},
			f = a === mb;

		function g(h) {
			var i;
			return e[h] = !0, n.each(a[h] || [], function(a, h) {
				var j = h(b, c, d);
				return "string" != typeof j || f || e[j] ? f ? !(i = j) : void 0 : (b.dataTypes.unshift(j), g(j), !1)
			}), i
		}
		return g(b.dataTypes[0]) || !e["*"] && g("*")
	}

	function sb(a, b) {
		var c, d, e = n.ajaxSettings.flatOptions || {};
		for(c in b) void 0 !== b[c] && ((e[c] ? a : d || (d = {}))[c] = b[c]);
		return d && n.extend(!0, a, d), a
	}

	function tb(a, b, c) {
		var d, e, f, g, h = a.contents,
			i = a.dataTypes;
		while("*" === i[0]) i.shift(), void 0 === d && (d = a.mimeType || b.getResponseHeader("Content-Type"));
		if(d)
			for(e in h)
				if(h[e] && h[e].test(d)) {
					i.unshift(e);
					break
				}
		if(i[0] in c) f = i[0];
		else {
			for(e in c) {
				if(!i[0] || a.converters[e + " " + i[0]]) {
					f = e;
					break
				}
				g || (g = e)
			}
			f = f || g
		}
		return f ? (f !== i[0] && i.unshift(f), c[f]) : void 0
	}

	function ub(a, b, c, d) {
		var e, f, g, h, i, j = {},
			k = a.dataTypes.slice();
		if(k[1])
			for(g in a.converters) j[g.toLowerCase()] = a.converters[g];
		f = k.shift();
		while(f)
			if(a.responseFields[f] && (c[a.responseFields[f]] = b), !i && d && a.dataFilter && (b = a.dataFilter(b, a.dataType)), i = f, f = k.shift())
				if("*" === f) f = i;
				else if("*" !== i && i !== f) {
			if(g = j[i + " " + f] || j["* " + f], !g)
				for(e in j)
					if(h = e.split(" "), h[1] === f && (g = j[i + " " + h[0]] || j["* " + h[0]])) {
						g === !0 ? g = j[e] : j[e] !== !0 && (f = h[0], k.unshift(h[1]));
						break
					}
			if(g !== !0)
				if(g && a["throws"]) b = g(b);
				else try {
					b = g(b)
				} catch(l) {
					return {
						state: "parsererror",
						error: g ? l : "No conversion from " + i + " to " + f
					}
				}
		}
		return {
			state: "success",
			data: b
		}
	}
	n.extend({
		active: 0,
		lastModified: {},
		etag: {},
		ajaxSettings: {
			url: ob,
			type: "GET",
			isLocal: hb.test(pb[1]),
			global: !0,
			processData: !0,
			async: !0,
			contentType: "application/x-www-form-urlencoded; charset=UTF-8",
			accepts: {
				"*": nb,
				text: "text/plain",
				html: "text/html",
				xml: "application/xml, text/xml",
				json: "application/json, text/javascript"
			},
			contents: {
				xml: /xml/,
				html: /html/,
				json: /json/
			},
			responseFields: {
				xml: "responseXML",
				text: "responseText",
				json: "responseJSON"
			},
			converters: {
				"* text": String,
				"text html": !0,
				"text json": n.parseJSON,
				"text xml": n.parseXML
			},
			flatOptions: {
				url: !0,
				context: !0
			}
		},
		ajaxSetup: function(a, b) {
			return b ? sb(sb(a, n.ajaxSettings), b) : sb(n.ajaxSettings, a)
		},
		ajaxPrefilter: qb(lb),
		ajaxTransport: qb(mb),
		ajax: function(a, b) {
			"object" == typeof a && (b = a, a = void 0), b = b || {};
			var c, d, e, f, g, h, i, j, k = n.ajaxSetup({}, b),
				l = k.context || k,
				m = k.context && (l.nodeType || l.jquery) ? n(l) : n.event,
				o = n.Deferred(),
				p = n.Callbacks("once memory"),
				q = k.statusCode || {},
				r = {},
				s = {},
				t = 0,
				u = "canceled",
				v = {
					readyState: 0,
					getResponseHeader: function(a) {
						var b;
						if(2 === t) {
							if(!f) {
								f = {};
								while(b = gb.exec(e)) f[b[1].toLowerCase()] = b[2]
							}
							b = f[a.toLowerCase()]
						}
						return null == b ? null : b
					},
					getAllResponseHeaders: function() {
						return 2 === t ? e : null
					},
					setRequestHeader: function(a, b) {
						var c = a.toLowerCase();
						return t || (a = s[c] = s[c] || a, r[a] = b), this
					},
					overrideMimeType: function(a) {
						return t || (k.mimeType = a), this
					},
					statusCode: function(a) {
						var b;
						if(a)
							if(2 > t)
								for(b in a) q[b] = [q[b], a[b]];
							else v.always(a[v.status]);
						return this
					},
					abort: function(a) {
						var b = a || u;
						return c && c.abort(b), x(0, b), this
					}
				};
			if(o.promise(v).complete = p.add, v.success = v.done, v.error = v.fail, k.url = ((a || k.url || ob) + "").replace(eb, "").replace(jb, pb[1] + "//"), k.type = b.method || b.type || k.method || k.type, k.dataTypes = n.trim(k.dataType || "*").toLowerCase().match(E) || [""], null == k.crossDomain && (h = kb.exec(k.url.toLowerCase()), k.crossDomain = !(!h || h[1] === pb[1] && h[2] === pb[2] && (h[3] || ("http:" === h[1] ? "80" : "443")) === (pb[3] || ("http:" === pb[1] ? "80" : "443")))), k.data && k.processData && "string" != typeof k.data && (k.data = n.param(k.data, k.traditional)), rb(lb, k, b, v), 2 === t) return v;
			i = n.event && k.global, i && 0 === n.active++ && n.event.trigger("ajaxStart"), k.type = k.type.toUpperCase(), k.hasContent = !ib.test(k.type), d = k.url, k.hasContent || (k.data && (d = k.url += (db.test(d) ? "&" : "?") + k.data, delete k.data), k.cache === !1 && (k.url = fb.test(d) ? d.replace(fb, "$1_=" + cb++) : d + (db.test(d) ? "&" : "?") + "_=" + cb++)), k.ifModified && (n.lastModified[d] && v.setRequestHeader("If-Modified-Since", n.lastModified[d]), n.etag[d] && v.setRequestHeader("If-None-Match", n.etag[d])), (k.data && k.hasContent && k.contentType !== !1 || b.contentType) && v.setRequestHeader("Content-Type", k.contentType), v.setRequestHeader("Accept", k.dataTypes[0] && k.accepts[k.dataTypes[0]] ? k.accepts[k.dataTypes[0]] + ("*" !== k.dataTypes[0] ? ", " + nb + "; q=0.01" : "") : k.accepts["*"]);
			for(j in k.headers) v.setRequestHeader(j, k.headers[j]);
			if(k.beforeSend && (k.beforeSend.call(l, v, k) === !1 || 2 === t)) return v.abort();
			u = "abort";
			for(j in {
					success: 1,
					error: 1,
					complete: 1
				}) v[j](k[j]);
			if(c = rb(mb, k, b, v)) {
				v.readyState = 1, i && m.trigger("ajaxSend", [v, k]), k.async && k.timeout > 0 && (g = setTimeout(function() {
					v.abort("timeout")
				}, k.timeout));
				try {
					t = 1, c.send(r, x)
				} catch(w) {
					if(!(2 > t)) throw w;
					x(-1, w)
				}
			} else x(-1, "No Transport");

			function x(a, b, f, h) {
				var j, r, s, u, w, x = b;
				2 !== t && (t = 2, g && clearTimeout(g), c = void 0, e = h || "", v.readyState = a > 0 ? 4 : 0, j = a >= 200 && 300 > a || 304 === a, f && (u = tb(k, v, f)), u = ub(k, u, v, j), j ? (k.ifModified && (w = v.getResponseHeader("Last-Modified"), w && (n.lastModified[d] = w), w = v.getResponseHeader("etag"), w && (n.etag[d] = w)), 204 === a || "HEAD" === k.type ? x = "nocontent" : 304 === a ? x = "notmodified" : (x = u.state, r = u.data, s = u.error, j = !s)) : (s = x, (a || !x) && (x = "error", 0 > a && (a = 0))), v.status = a, v.statusText = (b || x) + "", j ? o.resolveWith(l, [r, x, v]) : o.rejectWith(l, [v, x, s]), v.statusCode(q), q = void 0, i && m.trigger(j ? "ajaxSuccess" : "ajaxError", [v, k, j ? r : s]), p.fireWith(l, [v, x]), i && (m.trigger("ajaxComplete", [v, k]), --n.active || n.event.trigger("ajaxStop")))
			}
			return v
		},
		getJSON: function(a, b, c) {
			return n.get(a, b, c, "json")
		},
		getScript: function(a, b) {
			return n.get(a, void 0, b, "script")
		}
	}), n.each(["get", "post"], function(a, b) {
		n[b] = function(a, c, d, e) {
			return n.isFunction(c) && (e = e || d, d = c, c = void 0), n.ajax({
				url: a,
				type: b,
				dataType: e,
				data: c,
				success: d
			})
		}
	}), n._evalUrl = function(a) {
		return n.ajax({
			url: a,
			type: "GET",
			dataType: "script",
			async: !1,
			global: !1,
			"throws": !0
		})
	}, n.fn.extend({
		wrapAll: function(a) {
			var b;
			return n.isFunction(a) ? this.each(function(b) {
				n(this).wrapAll(a.call(this, b))
			}) : (this[0] && (b = n(a, this[0].ownerDocument).eq(0).clone(!0), this[0].parentNode && b.insertBefore(this[0]), b.map(function() {
				var a = this;
				while(a.firstElementChild) a = a.firstElementChild;
				return a
			}).append(this)), this)
		},
		wrapInner: function(a) {
			return this.each(n.isFunction(a) ? function(b) {
				n(this).wrapInner(a.call(this, b))
			} : function() {
				var b = n(this),
					c = b.contents();
				c.length ? c.wrapAll(a) : b.append(a)
			})
		},
		wrap: function(a) {
			var b = n.isFunction(a);
			return this.each(function(c) {
				n(this).wrapAll(b ? a.call(this, c) : a)
			})
		},
		unwrap: function() {
			return this.parent().each(function() {
				n.nodeName(this, "body") || n(this).replaceWith(this.childNodes)
			}).end()
		}
	}), n.expr.filters.hidden = function(a) {
		return a.offsetWidth <= 0 && a.offsetHeight <= 0
	}, n.expr.filters.visible = function(a) {
		return !n.expr.filters.hidden(a)
	};
	var vb = /%20/g,
		wb = /\[\]$/,
		xb = /\r?\n/g,
		yb = /^(?:submit|button|image|reset|file)$/i,
		zb = /^(?:input|select|textarea|keygen)/i;

	function Ab(a, b, c, d) {
		var e;
		if(n.isArray(b)) n.each(b, function(b, e) {
			c || wb.test(a) ? d(a, e) : Ab(a + "[" + ("object" == typeof e ? b : "") + "]", e, c, d)
		});
		else if(c || "object" !== n.type(b)) d(a, b);
		else
			for(e in b) Ab(a + "[" + e + "]", b[e], c, d)
	}
	n.param = function(a, b) {
		var c, d = [],
			e = function(a, b) {
				b = n.isFunction(b) ? b() : null == b ? "" : b, d[d.length] = encodeURIComponent(a) + "=" + encodeURIComponent(b)
			};
		if(void 0 === b && (b = n.ajaxSettings && n.ajaxSettings.traditional), n.isArray(a) || a.jquery && !n.isPlainObject(a)) n.each(a, function() {
			e(this.name, this.value)
		});
		else
			for(c in a) Ab(c, a[c], b, e);
		return d.join("&").replace(vb, "+")
	}, n.fn.extend({
		serialize: function() {
			return n.param(this.serializeArray())
		},
		serializeArray: function() {
			return this.map(function() {
				var a = n.prop(this, "elements");
				return a ? n.makeArray(a) : this
			}).filter(function() {
				var a = this.type;
				return this.name && !n(this).is(":disabled") && zb.test(this.nodeName) && !yb.test(a) && (this.checked || !T.test(a))
			}).map(function(a, b) {
				var c = n(this).val();
				return null == c ? null : n.isArray(c) ? n.map(c, function(a) {
					return {
						name: b.name,
						value: a.replace(xb, "\r\n")
					}
				}) : {
					name: b.name,
					value: c.replace(xb, "\r\n")
				}
			}).get()
		}
	}), n.ajaxSettings.xhr = function() {
		try {
			return new XMLHttpRequest
		} catch(a) {}
	};
	var Bb = 0,
		Cb = {},
		Db = {
			0: 200,
			1223: 204
		},
		Eb = n.ajaxSettings.xhr();
	a.attachEvent && a.attachEvent("onunload", function() {
		for(var a in Cb) Cb[a]()
	}), k.cors = !!Eb && "withCredentials" in Eb, k.ajax = Eb = !!Eb, n.ajaxTransport(function(a) {
		var b;
		return k.cors || Eb && !a.crossDomain ? {
			send: function(c, d) {
				var e, f = a.xhr(),
					g = ++Bb;
				if(f.open(a.type, a.url, a.async, a.username, a.password), a.xhrFields)
					for(e in a.xhrFields) f[e] = a.xhrFields[e];
				a.mimeType && f.overrideMimeType && f.overrideMimeType(a.mimeType), a.crossDomain || c["X-Requested-With"] || (c["X-Requested-With"] = "XMLHttpRequest");
				for(e in c) f.setRequestHeader(e, c[e]);
				b = function(a) {
					return function() {
						b && (delete Cb[g], b = f.onload = f.onerror = null, "abort" === a ? f.abort() : "error" === a ? d(f.status, f.statusText) : d(Db[f.status] || f.status, f.statusText, "string" == typeof f.responseText ? {
							text: f.responseText
						} : void 0, f.getAllResponseHeaders()))
					}
				}, f.onload = b(), f.onerror = b("error"), b = Cb[g] = b("abort");
				try {
					f.send(a.hasContent && a.data || null)
				} catch(h) {
					if(b) throw h
				}
			},
			abort: function() {
				b && b()
			}
		} : void 0
	}), n.ajaxSetup({
		accepts: {
			script: "text/javascript, application/javascript, application/ecmascript, application/x-ecmascript"
		},
		contents: {
			script: /(?:java|ecma)script/
		},
		converters: {
			"text script": function(a) {
				return n.globalEval(a), a
			}
		}
	}), n.ajaxPrefilter("script", function(a) {
		void 0 === a.cache && (a.cache = !1), a.crossDomain && (a.type = "GET")
	}), n.ajaxTransport("script", function(a) {
		if(a.crossDomain) {
			var b, c;
			return {
				send: function(d, e) {
					b = n("<script>").prop({
						async: !0,
						charset: a.scriptCharset,
						src: a.url
					}).on("load error", c = function(a) {
						b.remove(), c = null, a && e("error" === a.type ? 404 : 200, a.type)
					}), l.head.appendChild(b[0])
				},
				abort: function() {
					c && c()
				}
			}
		}
	});
	var Fb = [],
		Gb = /(=)\?(?=&|$)|\?\?/;
	n.ajaxSetup({
		jsonp: "callback",
		jsonpCallback: function() {
			var a = Fb.pop() || n.expando + "_" + cb++;
			return this[a] = !0, a
		}
	}), n.ajaxPrefilter("json jsonp", function(b, c, d) {
		var e, f, g, h = b.jsonp !== !1 && (Gb.test(b.url) ? "url" : "string" == typeof b.data && !(b.contentType || "").indexOf("application/x-www-form-urlencoded") && Gb.test(b.data) && "data");
		return h || "jsonp" === b.dataTypes[0] ? (e = b.jsonpCallback = n.isFunction(b.jsonpCallback) ? b.jsonpCallback() : b.jsonpCallback, h ? b[h] = b[h].replace(Gb, "$1" + e) : b.jsonp !== !1 && (b.url += (db.test(b.url) ? "&" : "?") + b.jsonp + "=" + e), b.converters["script json"] = function() {
			return g || n.error(e + " was not called"), g[0]
		}, b.dataTypes[0] = "json", f = a[e], a[e] = function() {
			g = arguments
		}, d.always(function() {
			a[e] = f, b[e] && (b.jsonpCallback = c.jsonpCallback, Fb.push(e)), g && n.isFunction(f) && f(g[0]), g = f = void 0
		}), "script") : void 0
	}), n.parseHTML = function(a, b, c) {
		if(!a || "string" != typeof a) return null;
		"boolean" == typeof b && (c = b, b = !1), b = b || l;
		var d = v.exec(a),
			e = !c && [];
		return d ? [b.createElement(d[1])] : (d = n.buildFragment([a], b, e), e && e.length && n(e).remove(), n.merge([], d.childNodes))
	};
	var Hb = n.fn.load;
	n.fn.load = function(a, b, c) {
		if("string" != typeof a && Hb) return Hb.apply(this, arguments);
		var d, e, f, g = this,
			h = a.indexOf(" ");
		return h >= 0 && (d = n.trim(a.slice(h)), a = a.slice(0, h)), n.isFunction(b) ? (c = b, b = void 0) : b && "object" == typeof b && (e = "POST"), g.length > 0 && n.ajax({
			url: a,
			type: e,
			dataType: "html",
			data: b
		}).done(function(a) {
			f = arguments, g.html(d ? n("<div>").append(n.parseHTML(a)).find(d) : a)
		}).complete(c && function(a, b) {
			g.each(c, f || [a.responseText, b, a])
		}), this
	}, n.each(["ajaxStart", "ajaxStop", "ajaxComplete", "ajaxError", "ajaxSuccess", "ajaxSend"], function(a, b) {
		n.fn[b] = function(a) {
			return this.on(b, a)
		}
	}), n.expr.filters.animated = function(a) {
		return n.grep(n.timers, function(b) {
			return a === b.elem
		}).length
	};
	var Ib = a.document.documentElement;

	function Jb(a) {
		return n.isWindow(a) ? a : 9 === a.nodeType && a.defaultView
	}
	n.offset = {
		setOffset: function(a, b, c) {
			var d, e, f, g, h, i, j, k = n.css(a, "position"),
				l = n(a),
				m = {};
			"static" === k && (a.style.position = "relative"), h = l.offset(), f = n.css(a, "top"), i = n.css(a, "left"), j = ("absolute" === k || "fixed" === k) && (f + i).indexOf("auto") > -1, j ? (d = l.position(), g = d.top, e = d.left) : (g = parseFloat(f) || 0, e = parseFloat(i) || 0), n.isFunction(b) && (b = b.call(a, c, h)), null != b.top && (m.top = b.top - h.top + g), null != b.left && (m.left = b.left - h.left + e), "using" in b ? b.using.call(a, m) : l.css(m)
		}
	}, n.fn.extend({
		offset: function(a) {
			if(arguments.length) return void 0 === a ? this : this.each(function(b) {
				n.offset.setOffset(this, a, b)
			});
			var b, c, d = this[0],
				e = {
					top: 0,
					left: 0
				},
				f = d && d.ownerDocument;
			if(f) return b = f.documentElement, n.contains(b, d) ? (typeof d.getBoundingClientRect !== U && (e = d.getBoundingClientRect()), c = Jb(f), {
				top: e.top + c.pageYOffset - b.clientTop,
				left: e.left + c.pageXOffset - b.clientLeft
			}) : e
		},
		position: function() {
			if(this[0]) {
				var a, b, c = this[0],
					d = {
						top: 0,
						left: 0
					};
				return "fixed" === n.css(c, "position") ? b = c.getBoundingClientRect() : (a = this.offsetParent(), b = this.offset(), n.nodeName(a[0], "html") || (d = a.offset()), d.top += n.css(a[0], "borderTopWidth", !0), d.left += n.css(a[0], "borderLeftWidth", !0)), {
					top: b.top - d.top - n.css(c, "marginTop", !0),
					left: b.left - d.left - n.css(c, "marginLeft", !0)
				}
			}
		},
		offsetParent: function() {
			return this.map(function() {
				var a = this.offsetParent || Ib;
				while(a && !n.nodeName(a, "html") && "static" === n.css(a, "position")) a = a.offsetParent;
				return a || Ib
			})
		}
	}), n.each({
		scrollLeft: "pageXOffset",
		scrollTop: "pageYOffset"
	}, function(b, c) {
		var d = "pageYOffset" === c;
		n.fn[b] = function(e) {
			return J(this, function(b, e, f) {
				var g = Jb(b);
				return void 0 === f ? g ? g[c] : b[e] : void(g ? g.scrollTo(d ? a.pageXOffset : f, d ? f : a.pageYOffset) : b[e] = f)
			}, b, e, arguments.length, null)
		}
	}), n.each(["top", "left"], function(a, b) {
		n.cssHooks[b] = ya(k.pixelPosition, function(a, c) {
			return c ? (c = xa(a, b), va.test(c) ? n(a).position()[b] + "px" : c) : void 0
		})
	}), n.each({
		Height: "height",
		Width: "width"
	}, function(a, b) {
		n.each({
			padding: "inner" + a,
			content: b,
			"": "outer" + a
		}, function(c, d) {
			n.fn[d] = function(d, e) {
				var f = arguments.length && (c || "boolean" != typeof d),
					g = c || (d === !0 || e === !0 ? "margin" : "border");
				return J(this, function(b, c, d) {
					var e;
					return n.isWindow(b) ? b.document.documentElement["client" + a] : 9 === b.nodeType ? (e = b.documentElement, Math.max(b.body["scroll" + a], e["scroll" + a], b.body["offset" + a], e["offset" + a], e["client" + a])) : void 0 === d ? n.css(b, c, g) : n.style(b, c, d, g)
				}, b, f ? d : void 0, f, null)
			}
		})
	}), n.fn.size = function() {
		return this.length
	}, n.fn.andSelf = n.fn.addBack, "function" == typeof define && define.amd && define("jquery", [], function() {
		return n
	});
	var Kb = a.jQuery,
		Lb = a.$;
	return n.noConflict = function(b) {
		return a.$ === n && (a.$ = Lb), b && a.jQuery === n && (a.jQuery = Kb), n
	}, typeof b === U && (a.jQuery = a.$ = n), n
});
/*! Amaze UI v2.4.2 | by Amaze UI Team | (c) 2015 AllMobilize, Inc. | Licensed under MIT | 2015-07-06T10:25:45+0800 */
! function(t) {
	if("object" == typeof exports && "undefined" != typeof module) module.exports = t();
	else if("function" == typeof define && define.amd) define([], t);
	else {
		var e;
		e = "undefined" != typeof window ? window : "undefined" != typeof global ? global : "undefined" != typeof self ? self : this, e.AMUI = t()
	}
}(function() {
	return function t(e, i, n) {
		function s(a, r) {
			if(!i[a]) {
				if(!e[a]) {
					var l = "function" == typeof require && require;
					if(!r && l) return l(a, !0);
					if(o) return o(a, !0);
					var c = new Error("Cannot find module '" + a + "'");
					throw c.code = "MODULE_NOT_FOUND", c
				}
				var u = i[a] = {
					exports: {}
				};
				e[a][0].call(u.exports, function(t) {
					var i = e[a][1][t];
					return s(i ? i : t)
				}, u, u.exports, t, e, i, n)
			}
			return i[a].exports
		}
		for(var o = "function" == typeof require && require, a = 0; a < n.length; a++) s(n[a]);
		return s
	}({
		1: [function(t, e, i) {
			"use strict";
			var n = window.jQuery,
				s = t(2);
			t(30), t(3), t(4), t(5), t(6), t(7), t(8), t(9), t(10), t(11), t(12), t(13), t(14), t(15), t(16), t(17), t(18), t(19), t(20), t(21), t(22), t(23), t(24), t(25), t(26), t(27), t(28), t(29), t(31), t(32), t(33), t(34), t(35), t(36), t(37), t(38), t(39), t(40), t(41), t(42), t(43), t(44), t(45), t(46), t(47), t(48), t(49), t(50), t(51), t(52), e.exports = n.AMUI = s
		}, {
			10: 10,
			11: 11,
			12: 12,
			13: 13,
			14: 14,
			15: 15,
			16: 16,
			17: 17,
			18: 18,
			19: 19,
			2: 2,
			20: 20,
			21: 21,
			22: 22,
			23: 23,
			24: 24,
			25: 25,
			26: 26,
			27: 27,
			28: 28,
			29: 29,
			3: 3,
			30: 30,
			31: 31,
			32: 32,
			33: 33,
			34: 34,
			35: 35,
			36: 36,
			37: 37,
			38: 38,
			39: 39,
			4: 4,
			40: 40,
			41: 41,
			42: 42,
			43: 43,
			44: 44,
			45: 45,
			46: 46,
			47: 47,
			48: 48,
			49: 49,
			5: 5,
			50: 50,
			51: 51,
			52: 52,
			6: 6,
			7: 7,
			8: 8,
			9: 9
		}],
		2: [function(t, e, i) {
			"use strict";
			var n = window.jQuery;
			if("undefined" == typeof n) throw new Error("Amaze UI 2.x requires jQuery :-(\n\u7231\u4e0a\u4e00\u5339\u91ce\u9a6c\uff0c\u53ef\u4f60\u7684\u5bb6\u91cc\u6ca1\u6709\u8349\u539f\u2026");
			var s = n.AMUI || {},
				o = n(window),
				a = window.document,
				r = n("html");
			s.VERSION = "2.4.2", s.support = {}, s.support.transition = function() {
				var t = function() {
					var t = a.body || a.documentElement,
						e = {
							WebkitTransition: "webkitTransitionEnd",
							MozTransition: "transitionend",
							OTransition: "oTransitionEnd otransitionend",
							transition: "transitionend"
						};
					for(var i in e)
						if(void 0 !== t.style[i]) return e[i]
				}();
				return t && {
					end: t
				}
			}(), s.support.animation = function() {
				var t = function() {
					var t = a.body || a.documentElement,
						e = {
							WebkitAnimation: "webkitAnimationEnd",
							MozAnimation: "animationend",
							OAnimation: "oAnimationEnd oanimationend",
							animation: "animationend"
						};
					for(var i in e)
						if(void 0 !== t.style[i]) return e[i]
				}();
				return t && {
					end: t
				}
			}(), s.support.touch = "ontouchstart" in window && navigator.userAgent.toLowerCase().match(/mobile|tablet/) || window.DocumentTouch && document instanceof window.DocumentTouch || window.navigator.msPointerEnabled && window.navigator.msMaxTouchPoints > 0 || window.navigator.pointerEnabled && window.navigator.maxTouchPoints > 0 || !1, s.support.mutationobserver = window.MutationObserver || window.WebKitMutationObserver || null, s.support.formValidation = "function" == typeof document.createElement("form").checkValidity, s.utils = {}, s.utils.debounce = function(t, e, i) {
				var n;
				return function() {
					var s = this,
						o = arguments,
						a = function() {
							n = null, i || t.apply(s, o)
						},
						r = i && !n;
					clearTimeout(n), n = setTimeout(a, e), r && t.apply(s, o)
				}
			}, s.utils.isInView = function(t, e) {
				var i = n(t),
					s = !(!i.width() && !i.height()) && "none" !== i.css("display");
				if(!s) return !1;
				var a = o.scrollLeft(),
					r = o.scrollTop(),
					l = i.offset(),
					c = l.left,
					u = l.top;
				return e = n.extend({
					topOffset: 0,
					leftOffset: 0
				}, e), u + i.height() >= r && u - e.topOffset <= r + o.height() && c + i.width() >= a && c - e.leftOffset <= a + o.width()
			}, s.utils.parseOptions = s.utils.options = function(t) {
				if(n.isPlainObject(t)) return t;
				var e = t ? t.indexOf("{") : -1,
					i = {};
				if(-1 != e) try {
					i = new Function("", "var json = " + t.substr(e) + "; return JSON.parse(JSON.stringify(json));")()
				} catch(s) {}
				return i
			}, s.utils.generateGUID = function(t) {
				var e = t + "-" || "am-";
				do e += Math.random().toString(36).substring(2, 7); while (document.getElementById(e));
				return e
			}, s.plugin = function(t, e, i) {
				var o = n.fn[t];
				i = i || {}, n.fn[t] = function(o) {
					var a, r = Array.prototype.slice.call(arguments, 0),
						l = r.slice(1),
						c = this.each(function() {
							var c = n(this),
								u = "amui." + t,
								h = i.dataOptions || "data-am-" + t,
								d = c.data(u),
								p = n.extend({}, s.utils.parseOptions(c.attr(h)), "object" == typeof o && o);
							(d || "destroy" !== o) && (d || c.data(u, d = new e(this, p)), i.methodCall ? i.methodCall.call(c, r, d) : (i.before && i.before.call(c, r, d), "string" == typeof o && (a = "function" == typeof d[o] ? d[o].apply(d, l) : d[o]), i.after && i.after.call(c, r, d)))
						});
					return void 0 === a ? c : a
				}, n.fn[t].Constructor = e, n.fn[t].noConflict = function() {
					return n.fn[t] = o, console.log(this), this
				}, s[t] = e
			}, n.fn.emulateTransitionEnd = function(t) {
				var e = !1,
					i = this;
				n(this).one(s.support.transition.end, function() {
					e = !0
				});
				var o = function() {
					e || n(i).trigger(s.support.transition.end), i.transitionEndTimmer = void 0
				};
				return this.transitionEndTimmer = setTimeout(o, t), this
			}, n.fn.redraw = function() {
				return this.each(function() {
					this.offsetHeight
				})
			}, n.fn.transitionEnd = function(t) {
				function e(s) {
					t.call(this, s), i && n.off(i, e)
				}
				var i = s.support.transition.end,
					n = this;
				return t && i && n.on(i, e), this
			}, n.fn.removeClassRegEx = function() {
				return this.each(function(t) {
					var e = n(this).attr("class");
					if(!e || !t) return !1;
					var i = [];
					e = e.split(" ");
					for(var s = 0, o = e.length; o > s; s++) e[s].match(t) || i.push(e[s]);
					n(this).attr("class", i.join(" "))
				})
			}, n.fn.alterClass = function(t, e) {
				var i = this;
				if(-1 === t.indexOf("*")) return i.removeClass(t), e ? i.addClass(e) : i;
				var s = new RegExp("\\s" + t.replace(/\*/g, "[A-Za-z0-9-_]+").split(" ").join("\\s|\\s") + "\\s", "g");
				return i.each(function(t, e) {
					for(var i = " " + e.className + " "; s.test(i);) i = i.replace(s, " ");
					e.className = n.trim(i)
				}), e ? i.addClass(e) : i
			}, s.utils.rAF = function() {
				return window.requestAnimationFrame || window.webkitRequestAnimationFrame || window.mozRequestAnimationFrame || window.oRequestAnimationFrame || function(t) {
					return window.setTimeout(t, 1e3 / 60)
				}
			}(), s.utils.cancelAF = function() {
				return window.cancelAnimationFrame || window.webkitCancelAnimationFrame || window.mozCancelAnimationFrame || window.oCancelAnimationFrame || function(t) {
					window.clearTimeout(t)
				}
			}(), s.utils.measureScrollbar = function() {
				if(document.body.clientWidth >= window.innerWidth) return 0;
				var t = n('<div style="width: 100px;height: 100px;overflow: scroll;position: absolute;top: -9999px;"></div>');
				n(document.body).append(t);
				var e = t[0].offsetWidth - t[0].clientWidth;
				return t.remove(), e
			}, s.utils.imageLoader = function(t, e) {
				function i() {
					e(t[0])
				}

				function n() {
					if(this.one("load", i), /MSIE (\d+\.\d+);/.test(navigator.userAgent)) {
						var t = this.attr("src"),
							e = t.match(/\?/) ? "&" : "?";
						e += "random=" + (new Date).getTime(), this.attr("src", t + e)
					}
				}
				return t.attr("src") ? void(t[0].complete || 4 === t[0].readyState ? i() : n.call(t)) : void i()
			}, s.template = function(t, e) {
				var i = s.template;
				return i.cache[t] || (i.cache[t] = function() {
					var e = t,
						n = /^[\w\-]+$/.test(t) ? i.get(t) : (e = "template(string)", t),
						s = 1,
						o = ("try { " + (i.variable ? "var " + i.variable + " = this.stash;" : "with (this.stash) { ") + "this.ret += '" + n.replace(/<%/g, "").replace(/%>/g, "").replace(/'(?![^\x11\x13]+?\x13)/g, "\\x27").replace(/^\s*|\s*$/g, "").replace(/\n/g, function() {
							return "';\nthis.line = " + ++s + "; this.ret += '\\n"
						}).replace(/\x11-(.+?)\x13/g, "' + ($1) + '").replace(/\x11=(.+?)\x13/g, "' + this.escapeHTML($1) + '").replace(/\x11(.+?)\x13/g, "'; $1; this.ret += '") + "'; " + (i.variable ? "" : "}") + "return this.ret;} catch (e) { throw 'TemplateError: ' + e + ' (on " + e + "' + ' line ' + this.line + ')'; } //@ sourceURL=" + e + "\n").replace(/this\.ret \+= '';/g, ""),
						a = new Function(o),
						r = {
							"&": "&amp;",
							"<": "&lt;",
							">": "&gt;",
							'"': "&#x22;",
							"'": "&#x27;"
						},
						l = function(t) {
							return("" + t).replace(/[&<>\'\"]/g, function(t) {
								return r[t]
							})
						};
					return function(t) {
						return a.call(i.context = {
							escapeHTML: l,
							line: 1,
							ret: "",
							stash: t
						})
					}
				}()), e ? i.cache[t](e) : i.cache[t]
			}, s.template.cache = {}, s.template.get = function(t) {
				if(t) {
					var e = document.getElementById(t);
					return e && e.innerHTML || ""
				}
			}, s.DOMWatchers = [], s.DOMReady = !1, s.ready = function(t) {
				s.DOMWatchers.push(t), s.DOMReady && t(document)
			}, s.DOMObserve = function(t, e, i) {
				var o = s.support.mutationobserver;
				o && (e = n.isPlainObject(e) ? e : {
					childList: !0,
					subtree: !0
				}, i = "function" == typeof i && i || function() {}, n(t).each(function() {
					var t = this,
						a = n(t);
					if(!a.data("am.observer")) try {
						var r = new o(s.utils.debounce(function(e, n) {
							i.call(t, e, n), a.trigger("changed.dom.amui")
						}, 50));
						r.observe(t, e), a.data("am.observer", r)
					} catch(l) {}
				}))
			}, n.fn.DOMObserve = function(t, e) {
				return this.each(function() {
					s.DOMObserve(this, t, e)
				})
			}, s.support.touch && r.addClass("am-touch"), n(document).on("changed.dom.amui", function(t) {
				var e = t.target;
				n.each(s.DOMWatchers, function(t, i) {
					i(e)
				})
			}), n(function() {
				var t = n("body");
				s.DOMReady = !0, n.each(s.DOMWatchers, function(t, e) {
					e(document)
				}), s.DOMObserve("[data-am-observe]"), r.removeClass("no-js").addClass("js"), s.support.animation && r.addClass("cssanimations"), window.navigator.standalone && r.addClass("am-standalone"), n(".am-topbar-fixed-top").length && t.addClass("am-with-topbar-fixed-top"), n(".am-topbar-fixed-bottom").length && t.addClass("am-with-topbar-fixed-bottom");
				var e = n(".am-layout");
				e.find('[class*="md-block-grid"]').alterClass("md-block-grid-*"), e.find('[class*="lg-block-grid"]').alterClass("lg-block-grid"), n("[data-am-widget]").each(function() {
					var t = n(this);
					0 === t.parents(".am-layout").length && t.addClass("am-no-layout")
				})
			}), e.exports = s
		}, {}],
		3: [function(t, e, i) {
			"use strict";

			function n() {
				window.removeEventListener("load", n, !1), c = !0
			}

			function s(t) {
				return u = u || new s.Class(t)
			}

			function o(t, e) {
				for(var i in e) t[i] = e[i];
				return t
			}

			function a() {
				"#ath" == document.location.hash && history.replaceState("", window.document.title, document.location.href.split("#")[0]), h.test(document.location.href) && history.replaceState("", window.document.title, document.location.href.replace(h, "$1")), d.test(document.location.search) && history.replaceState("", window.document.title, document.location.href.replace(d, "$2"))
			}
			var r = t(2),
				l = "addEventListener" in window,
				c = !1;
			"complete" === document.readyState ? c = !0 : l && window.addEventListener("load", n, !1);
			var u, h = /\/ath(\/)?$/,
				d = /([\?&]ath=[^&]*$|&ath=[^&]*(&))/;
			s.intl = {
				en_us: {
					ios: "To add this web app to the home screen: tap %icon and then <strong>Add to Home Screen</strong>.",
					android: 'To add this web app to the home screen open the browser option menu and tap on <strong>Add to homescreen</strong>. <small>The menu can be accessed by pressing the menu hardware button if your device has one, or by tapping the top right menu icon <span class="ath-action-icon">icon</span>.</small>'
				},
				zh_cn: {
					ios: "\u5982\u8981\u628a\u5e94\u7528\u7a0b\u5f0f\u52a0\u81f3\u4e3b\u5c4f\u5e55,\u8bf7\u70b9\u51fb%icon, \u7136\u540e<strong>\u52a0\u81f3\u4e3b\u5c4f\u5e55</strong>",
					android: 'To add this web app to the home screen open the browser option menu and tap on <strong>Add to homescreen</strong>. <small>The menu can be accessed by pressing the menu hardware button if your device has one, or by tapping the top right menu icon <span class="ath-action-icon">icon</span>.</small>'
				},
				zh_tw: {
					ios: "\u5982\u8981\u628a\u61c9\u7528\u7a0b\u5f0f\u52a0\u81f3\u4e3b\u5c4f\u5e55, \u8acb\u9ede\u64ca%icon, \u7136\u5f8c<strong>\u52a0\u81f3\u4e3b\u5c4f\u5e55</strong>.",
					android: 'To add this web app to the home screen open the browser option menu and tap on <strong>Add to homescreen</strong>. <small>The menu can be accessed by pressing the menu hardware button if your device has one, or by tapping the top right menu icon <span class="ath-action-icon">icon</span>.</small>'
				}
			};
			for(var p in s.intl) s.intl[p.substr(0, 2)] = s.intl[p];
			s.defaults = {
				appID: "org.cubiq.addtohome",
				fontSize: 15,
				debug: !1,
				logging: !1,
				modal: !1,
				mandatory: !1,
				autostart: !0,
				skipFirstVisit: !1,
				startDelay: 1,
				lifespan: 15,
				displayPace: 1440,
				maxDisplayCount: 0,
				icon: !0,
				message: "",
				validLocation: [],
				onInit: null,
				onShow: null,
				onRemove: null,
				onAdd: null,
				onPrivate: null,
				privateModeOverride: !1,
				detectHomescreen: !1
			};
			var m = window.navigator.userAgent,
				f = window.navigator;
			o(s, {
				hasToken: "#ath" == document.location.hash || h.test(document.location.href) || d.test(document.location.search),
				isRetina: window.devicePixelRatio && window.devicePixelRatio > 1,
				isIDevice: /iphone|ipod|ipad/i.test(m),
				isMobileChrome: m.indexOf("Android") > -1 && /Chrome\/[.0-9]*/.test(m) && -1 == m.indexOf("Version"),
				isMobileIE: m.indexOf("Windows Phone") > -1,
				language: f.language && f.language.toLowerCase().replace("-", "_") || ""
			}), s.language = s.language && s.language in s.intl ? s.language : "en_us", s.isMobileSafari = s.isIDevice && m.indexOf("Safari") > -1 && m.indexOf("CriOS") < 0, s.OS = s.isIDevice ? "ios" : s.isMobileChrome ? "android" : s.isMobileIE ? "windows" : "unsupported", s.OSVersion = m.match(/(OS|Android) (\d+[_\.]\d+)/), s.OSVersion = s.OSVersion && s.OSVersion[2] ? +s.OSVersion[2].replace("_", ".") : 0, s.isStandalone = "standalone" in window.navigator && window.navigator.standalone, s.isTablet = s.isMobileSafari && m.indexOf("iPad") > -1 || s.isMobileChrome && m.indexOf("Mobile") < 0, s.isCompatible = s.isMobileSafari && s.OSVersion >= 6 || s.isMobileChrome;
			var v = {
				lastDisplayTime: 0,
				returningVisitor: !1,
				displayCount: 0,
				optedout: !1,
				added: !1
			};
			s.removeSession = function(t) {
				try {
					if(!localStorage) throw new Error("localStorage is not defined");
					localStorage.removeItem(t || s.defaults.appID)
				} catch(e) {}
			}, s.doLog = function(t) {
				this.options.logging && console.log(t)
			}, s.Class = function(t) {
				if(this.doLog = s.doLog, this.options = o({}, s.defaults), o(this.options, t), t.debug && "undefined" == typeof t.logging && (this.options.logging = !0), l) {
					if(this.options.mandatory = this.options.mandatory && ("standalone" in window.navigator || this.options.debug), this.options.modal = this.options.modal || this.options.mandatory, this.options.mandatory && (this.options.startDelay = -.5), this.options.detectHomescreen = this.options.detectHomescreen === !0 ? "hash" : this.options.detectHomescreen, this.options.debug && (s.isCompatible = !0, s.OS = "string" == typeof this.options.debug ? this.options.debug : "unsupported" == s.OS ? "android" : s.OS, s.OSVersion = "ios" == s.OS ? "8" : "4"), this.container = document.documentElement, this.session = this.getItem(this.options.appID), this.session = this.session ? JSON.parse(this.session) : void 0, !s.hasToken || s.isCompatible && this.session || (s.hasToken = !1, a()), !s.isCompatible) return void this.doLog("Add to homescreen: not displaying callout because device not supported");
					this.session = this.session || v;
					try {
						if(!localStorage) throw new Error("localStorage is not defined");
						localStorage.setItem(this.options.appID, JSON.stringify(this.session)), s.hasLocalStorage = !0
					} catch(e) {
						s.hasLocalStorage = !1, this.options.onPrivate && this.options.onPrivate.call(this)
					}
					for(var i = !this.options.validLocation.length, n = this.options.validLocation.length; n--;)
						if(this.options.validLocation[n].test(document.location.href)) {
							i = !0;
							break
						}
					if(this.getItem("addToHome") && this.optOut(), this.session.optedout) return void this.doLog("Add to homescreen: not displaying callout because user opted out");
					if(this.session.added) return void this.doLog("Add to homescreen: not displaying callout because already added to the homescreen");
					if(!i) return void this.doLog("Add to homescreen: not displaying callout because not a valid location");
					if(s.isStandalone) return this.session.added || (this.session.added = !0, this.updateSession(), this.options.onAdd && s.hasLocalStorage && this.options.onAdd.call(this)), void this.doLog("Add to homescreen: not displaying callout because in standalone mode");
					if(this.options.detectHomescreen) {
						if(s.hasToken) return a(), this.session.added || (this.session.added = !0, this.updateSession(), this.options.onAdd && s.hasLocalStorage && this.options.onAdd.call(this)), void this.doLog("Add to homescreen: not displaying callout because URL has token, so we are likely coming from homescreen");
						"hash" == this.options.detectHomescreen ? history.replaceState("", window.document.title, document.location.href + "#ath") : "smartURL" == this.options.detectHomescreen ? history.replaceState("", window.document.title, document.location.href.replace(/(\/)?$/, "/ath$1")) : history.replaceState("", window.document.title, document.location.href + (document.location.search ? "&" : "?") + "ath=")
					}
					if(!this.session.returningVisitor && (this.session.returningVisitor = !0, this.updateSession(), this.options.skipFirstVisit)) return void this.doLog("Add to homescreen: not displaying callout because skipping first visit");
					if(!this.options.privateModeOverride && !s.hasLocalStorage) return void this.doLog("Add to homescreen: not displaying callout because browser is in private mode");
					this.ready = !0, this.options.onInit && this.options.onInit.call(this), this.options.autostart && (this.doLog("Add to homescreen: autostart displaying callout"), this.show())
				}
			}, s.Class.prototype = {
				events: {
					load: "_delayedShow",
					error: "_delayedShow",
					orientationchange: "resize",
					resize: "resize",
					scroll: "resize",
					click: "remove",
					touchmove: "_preventDefault",
					transitionend: "_removeElements",
					webkitTransitionEnd: "_removeElements",
					MSTransitionEnd: "_removeElements"
				},
				handleEvent: function(t) {
					var e = this.events[t.type];
					e && this[e](t)
				},
				show: function(t) {
					if(this.options.autostart && !c) return void setTimeout(this.show.bind(this), 50);
					if(this.shown) return void this.doLog("Add to homescreen: not displaying callout because already shown on screen");
					var e = Date.now(),
						i = this.session.lastDisplayTime;
					if(t !== !0) {
						if(!this.ready) return void this.doLog("Add to homescreen: not displaying callout because not ready");
						if(e - i < 6e4 * this.options.displayPace) return void this.doLog("Add to homescreen: not displaying callout because displayed recently");
						if(this.options.maxDisplayCount && this.session.displayCount >= this.options.maxDisplayCount) return void this.doLog("Add to homescreen: not displaying callout because displayed too many times already")
					}
					this.shown = !0, this.session.lastDisplayTime = e, this.session.displayCount++, this.updateSession(), this.applicationIcon || (this.applicationIcon = document.querySelector("ios" == s.OS ? 'head link[rel^=apple-touch-icon][sizes="152x152"],head link[rel^=apple-touch-icon][sizes="144x144"],head link[rel^=apple-touch-icon][sizes="120x120"],head link[rel^=apple-touch-icon][sizes="114x114"],head link[rel^=apple-touch-icon]' : 'head link[rel^="shortcut icon"][sizes="196x196"],head link[rel^=apple-touch-icon]'));
					var n = "";
					"object" == typeof this.options.message && s.language in this.options.message ? n = this.options.message[s.language][s.OS] : "object" == typeof this.options.message && s.OS in this.options.message ? n = this.options.message[s.OS] : this.options.message in s.intl ? n = s.intl[this.options.message][s.OS] : "" !== this.options.message ? n = this.options.message : s.OS in s.intl[s.language] && (n = s.intl[s.language][s.OS]), n = "<p>" + n.replace("%icon", '<span class="ath-action-icon">icon</span>') + "</p>", this.viewport = document.createElement("div"), this.viewport.className = "ath-viewport", this.options.modal && (this.viewport.className += " ath-modal"), this.options.mandatory && (this.viewport.className += " ath-mandatory"), this.viewport.style.position = "absolute", this.element = document.createElement("div"), this.element.className = "ath-container ath-" + s.OS + " ath-" + s.OS + (s.OSVersion + "").substr(0, 1) + " ath-" + (s.isTablet ? "tablet" : "phone"), this.element.style.cssText = "-webkit-transition-property:-webkit-transform,opacity;-webkit-transition-duration:0s;-webkit-transition-timing-function:ease-out;transition-property:transform,opacity;transition-duration:0s;transition-timing-function:ease-out;", this.element.style.webkitTransform = "translate3d(0,-" + window.innerHeight + "px,0)", this.element.style.transform = "translate3d(0,-" + window.innerHeight + "px,0)", this.options.icon && this.applicationIcon && (this.element.className += " ath-icon", this.img = document.createElement("img"), this.img.className = "ath-application-icon", this.img.addEventListener("load", this, !1), this.img.addEventListener("error", this, !1), this.img.src = this.applicationIcon.href, this.element.appendChild(this.img)), this.element.innerHTML += n, this.viewport.style.left = "-99999em", this.viewport.appendChild(this.element), this.container.appendChild(this.viewport), this.img ? this.doLog("Add to homescreen: not displaying callout because waiting for img to load") : this._delayedShow()
				},
				_delayedShow: function(t) {
					setTimeout(this._show.bind(this), 1e3 * this.options.startDelay + 500)
				},
				_show: function() {
					var t = this;
					this.updateViewport(), window.addEventListener("resize", this, !1), window.addEventListener("scroll", this, !1), window.addEventListener("orientationchange", this, !1), this.options.modal && document.addEventListener("touchmove", this, !0), this.options.mandatory || setTimeout(function() {
						t.element.addEventListener("click", t, !0)
					}, 1e3), setTimeout(function() {
						t.element.style.webkitTransitionDuration = "1.2s", t.element.style.transitionDuration = "1.2s", t.element.style.webkitTransform = "translate3d(0,0,0)", t.element.style.transform = "translate3d(0,0,0)"
					}, 0), this.options.lifespan && (this.removeTimer = setTimeout(this.remove.bind(this), 1e3 * this.options.lifespan)), this.options.onShow && this.options.onShow.call(this)
				},
				remove: function() {
					clearTimeout(this.removeTimer), this.img && (this.img.removeEventListener("load", this, !1), this.img.removeEventListener("error", this, !1)), window.removeEventListener("resize", this, !1), window.removeEventListener("scroll", this, !1), window.removeEventListener("orientationchange", this, !1), document.removeEventListener("touchmove", this, !0), this.element.removeEventListener("click", this, !0), this.element.addEventListener("transitionend", this, !1), this.element.addEventListener("webkitTransitionEnd", this, !1), this.element.addEventListener("MSTransitionEnd", this, !1), this.element.style.webkitTransitionDuration = "0.3s", this.element.style.opacity = "0"
				},
				_removeElements: function() {
					this.element.removeEventListener("transitionend", this, !1), this.element.removeEventListener("webkitTransitionEnd", this, !1), this.element.removeEventListener("MSTransitionEnd", this, !1), this.container.removeChild(this.viewport), this.shown = !1, this.options.onRemove && this.options.onRemove.call(this)
				},
				updateViewport: function() {
					if(this.shown) {
						this.viewport.style.width = window.innerWidth + "px", this.viewport.style.height = window.innerHeight + "px", this.viewport.style.left = window.scrollX + "px", this.viewport.style.top = window.scrollY + "px";
						var t = document.documentElement.clientWidth;
						this.orientation = t > document.documentElement.clientHeight ? "landscape" : "portrait";
						var e = "ios" == s.OS ? "portrait" == this.orientation ? screen.width : screen.height : screen.width;
						this.scale = screen.width > t ? 1 : e / window.innerWidth, this.element.style.fontSize = this.options.fontSize / this.scale + "px"
					}
				},
				resize: function() {
					clearTimeout(this.resizeTimer), this.resizeTimer = setTimeout(this.updateViewport.bind(this), 100)
				},
				updateSession: function() {
					s.hasLocalStorage !== !1 && localStorage && localStorage.setItem(this.options.appID, JSON.stringify(this.session))
				},
				clearSession: function() {
					this.session = v, this.updateSession()
				},
				getItem: function(t) {
					try {
						if(!localStorage) throw new Error("localStorage is not defined");
						return localStorage.getItem(t)
					} catch(e) {
						s.hasLocalStorage = !1
					}
				},
				optOut: function() {
					this.session.optedout = !0, this.updateSession()
				},
				optIn: function() {
					this.session.optedout = !1, this.updateSession()
				},
				clearDisplayCount: function() {
					this.session.displayCount = 0, this.updateSession()
				},
				_preventDefault: function(t) {
					t.preventDefault(), t.stopPropagation()
				}
			}, s.VERSION = "3.2.2", e.exports = r.addToHomescreen = s
		}, {
			2: 2
		}],
		4: [function(t, e, i) {
			"use strict";
			var n = window.jQuery,
				s = t(2),
				o = function(t, e) {
					var i = this;
					this.options = n.extend({}, o.DEFAULTS, e), this.$element = n(t), this.$element.addClass("am-fade am-in").on("click.alert.amui", ".am-close", function() {
						i.close()
					})
				};
			o.DEFAULTS = {
				removeElement: !0
			}, o.prototype.close = function() {
				function t() {
					e.trigger("closed.alert.amui").remove()
				}
				var e = this.$element;
				e.trigger("close.alert.amui").removeClass("am-in"), s.support.transition && e.hasClass("am-fade") ? e.one(s.support.transition.end, t).emulateTransitionEnd(200) : t()
			}, s.plugin("alert", o), n(document).on("click.alert.amui.data-api", "[data-am-alert]", function(t) {
				var e = n(t.target);
				e.is(".am-close") && n(this).alert("close")
			}), e.exports = o
		}, {
			2: 2
		}],
		5: [function(t, e, i) {
			"use strict";
			var n = window.jQuery,
				s = t(2),
				o = function(t, e) {
					this.$element = n(t), this.options = n.extend({}, o.DEFAULTS, e), this.isLoading = !1, this.hasSpinner = !1
				};
			o.DEFAULTS = {
				loadingText: "loading...",
				disabledClassName: "am-disabled",
				spinner: void 0
			}, o.prototype.setState = function(t, e) {
				var i = this.$element,
					o = "disabled",
					a = i.data(),
					r = this.options,
					l = i.is("input") ? "val" : "html",
					c = "am-btn-" + t + " " + r.disabledClassName;
				t += "Text", r.resetText || (r.resetText = i[l]()), s.support.animation && r.spinner && "html" === l && !this.hasSpinner && (r.loadingText = '<span class="am-icon-' + r.spinner + ' am-icon-spin"></span>' + r.loadingText, this.hasSpinner = !0), e = e || (void 0 === a[t] ? r[t] : a[t]), i[l](e), setTimeout(n.proxy(function() {
					"loadingText" === t ? (i.addClass(c).attr(o, o), this.isLoading = !0) : this.isLoading && (i.removeClass(c).removeAttr(o), this.isLoading = !1)
				}, this), 0)
			}, o.prototype.toggle = function() {
				var t = !0,
					e = this.$element,
					i = this.$element.parent('[class*="am-btn-group"]');
				if(i.length) {
					var n = this.$element.find("input");
					"radio" == n.prop("type") && (n.prop("checked") && e.hasClass("am-active") ? t = !1 : i.find(".am-active").removeClass("am-active")), t && n.prop("checked", !e.hasClass("am-active")).trigger("change")
				}
				t && (e.toggleClass("am-active"), e.hasClass("am-active") || e.blur())
			}, s.plugin("button", o, {
				dataOptions: "data-am-loading",
				methodCall: function(t, e) {
					"toggle" === t[0] ? e.toggle() : "string" == typeof t[0] && e.setState.apply(e, t)
				}
			}), n(document).on("click.button.amui.data-api", "[data-am-button]", function(t) {
				t.preventDefault();
				var e = n(t.target);
				e.hasClass("am-btn") || (e = e.closest(".am-btn")), e.button("toggle")
			}), s.ready(function(t) {
				n("[data-am-loading]", t).button()
			}), e.exports = s.button = o
		}, {
			2: 2
		}],
		6: [function(t, e, i) {
			"use strict";

			function n(t) {
				return this.each(function() {
					var e = s(this),
						i = e.data("amui.collapse"),
						n = s.extend({}, a.DEFAULTS, o.utils.options(e.attr("data-am-collapse")), "object" == typeof t && t);
					!i && n.toggle && "open" === t && (t = !t), i || e.data("amui.collapse", i = new a(this, n)), "string" == typeof t && i[t]()
				})
			}
			var s = window.jQuery,
				o = t(2),
				a = function(t, e) {
					this.$element = s(t), this.options = s.extend({}, a.DEFAULTS, e), this.transitioning = null, this.options.parent && (this.$parent = s(this.options.parent)), this.options.toggle && this.toggle()
				};
			a.DEFAULTS = {
				toggle: !0
			}, a.prototype.open = function() {
				if(!this.transitioning && !this.$element.hasClass("am-in")) {
					var t = s.Event("open.collapse.amui");
					if(this.$element.trigger(t), !t.isDefaultPrevented()) {
						var e = this.$parent && this.$parent.find("> .am-panel > .am-in");
						if(e && e.length) {
							var i = e.data("amui.collapse");
							if(i && i.transitioning) return;
							n.call(e, "close"), i || e.data("amui.collapse", null)
						}
						this.$element.removeClass("am-collapse").addClass("am-collapsing").height(0), this.transitioning = 1;
						var a = function() {
							this.$element.removeClass("am-collapsing").addClass("am-collapse am-in").height("").trigger("opened.collapse.amui"), this.transitioning = 0
						};
						if(!o.support.transition) return a.call(this);
						var r = this.$element[0].scrollHeight;
						this.$element.one(o.support.transition.end, s.proxy(a, this)).emulateTransitionEnd(300).css({
							height: r
						})
					}
				}
			}, a.prototype.close = function() {
				if(!this.transitioning && this.$element.hasClass("am-in")) {
					var t = s.Event("close.collapse.amui");
					if(this.$element.trigger(t), !t.isDefaultPrevented()) {
						this.$element.height(this.$element.height()).redraw(), this.$element.addClass("am-collapsing").removeClass("am-collapse am-in"), this.transitioning = 1;
						var e = function() {
							this.transitioning = 0, this.$element.trigger("closed.collapse.amui").removeClass("am-collapsing").addClass("am-collapse")
						};
						return o.support.transition ? void this.$element.height(0).one(o.support.transition.end, s.proxy(e, this)).emulateTransitionEnd(300) : e.call(this)
					}
				}
			}, a.prototype.toggle = function() {
				this[this.$element.hasClass("am-in") ? "close" : "open"]()
			}, s.fn.collapse = n, s(document).on("click.collapse.amui.data-api", "[data-am-collapse]", function(t) {
				var e, i = s(this),
					a = o.utils.options(i.attr("data-am-collapse")),
					r = a.target || t.preventDefault() || (e = i.attr("href")) && e.replace(/.*(?=#[^\s]+$)/, ""),
					l = s(r),
					c = l.data("amui.collapse"),
					u = c ? "toggle" : a,
					h = a.parent,
					d = h && s(h);
				c && c.transitioning || (d && d.find("[data-am-collapse]").not(i).addClass("am-collapsed"), i[l.hasClass("am-in") ? "addClass" : "removeClass"]("am-collapsed")), n.call(l, u)
			}), e.exports = o.collapse = a
		}, {
			2: 2
		}],
		7: [function(t, e, i) {
			"use strict";
			var n = window.jQuery,
				s = t(2),
				o = n(document),
				a = function(t, e) {
					if(this.$element = n(t), this.options = n.extend({}, a.DEFAULTS, e), this.format = r.parseFormat(this.options.format), this.$element.data("date", this.options.date), this.language = this.getLocale(this.options.locale), this.theme = this.options.theme, this.$picker = n(r.template).appendTo("body").on({
							click: n.proxy(this.click, this)
						}), this.isInput = this.$element.is("input"), this.component = this.$element.is(".am-datepicker-date") ? this.$element.find(".am-datepicker-add-on") : !1, this.isInput ? this.$element.on({
							"click.datepicker.amui": n.proxy(this.open, this),
							"keyup.datepicker.amui": n.proxy(this.update, this)
						}) : this.component ? this.component.on("click.datepicker.amui", n.proxy(this.open, this)) : this.$element.on("click.datepicker.amui", n.proxy(this.open, this)), this.minViewMode = this.options.minViewMode, "string" == typeof this.minViewMode) switch(this.minViewMode) {
						case "months":
							this.minViewMode = 1;
							break;
						case "years":
							this.minViewMode = 2;
							break;
						default:
							this.minViewMode = 0
					}
					if(this.viewMode = this.options.viewMode, "string" == typeof this.viewMode) switch(this.viewMode) {
						case "months":
							this.viewMode = 1;
							break;
						case "years":
							this.viewMode = 2;
							break;
						default:
							this.viewMode = 0
					}
					this.startViewMode = this.viewMode, this.weekStart = (this.options.weekStart || a.locales[this.language].weekStart || 0) % 7, this.weekEnd = (this.weekStart + 6) % 7, this.onRender = this.options.onRender, this.setTheme(), this.fillDow(), this.fillMonths(), this.update(), this.showMode()
				};
			a.DEFAULTS = {
				locale: "zh_CN",
				format: "yyyy-mm-dd",
				weekStart: void 0,
				viewMode: 0,
				minViewMode: 0,
				date: "",
				theme: "",
				autoClose: 1,
				onRender: function(t) {
					return ""
				}
			}, a.prototype.open = function(t) {
				this.$picker.show(), this.height = this.component ? this.component.outerHeight() : this.$element.outerHeight(), this.place(), n(window).on("resize.datepicker.amui", n.proxy(this.place, this)), t && (t.stopPropagation(), t.preventDefault());
				var e = this;
				o.on("mousedown.datapicker.amui touchstart.datepicker.amui", function(t) {
					0 === n(t.target).closest(".am-datepicker").length && e.close()
				}), this.$element.trigger({
					type: "open.datepicker.amui",
					date: this.date
				})
			}, a.prototype.close = function() {
				this.$picker.hide(), n(window).off("resize.datepicker.amui", this.place), this.viewMode = this.startViewMode, this.showMode(), this.isInput || n(document).off("mousedown.datapicker.amui touchstart.datepicker.amui", this.close), this.$element.trigger({
					type: "close.datepicker.amui",
					date: this.date
				})
			}, a.prototype.set = function() {
				var t = r.formatDate(this.date, this.format);
				this.isInput ? this.$element.prop("value", t) : (this.component && this.$element.find("input").prop("value", t), this.$element.data("date", t))
			}, a.prototype.setValue = function(t) {
				this.date = "string" == typeof t ? r.parseDate(t, this.format) : new Date(t), this.set(), this.viewDate = new Date(this.date.getFullYear(), this.date.getMonth(), 1, 0, 0, 0, 0), this.fill()
			}, a.prototype.place = function() {
				var t = this.component ? this.component.offset() : this.$element.offset(),
					e = this.component ? this.component.width() : this.$element.width(),
					i = t.top + this.height,
					n = t.left,
					s = o.width() - t.left - e,
					a = this.isOutView();
				if(this.$picker.removeClass("am-datepicker-right"), this.$picker.removeClass("am-datepicker-up"), o.width() > 640) {
					if(a.outRight) return this.$picker.addClass("am-datepicker-right"), void this.$picker.css({
						top: i,
						left: "auto",
						right: s
					});
					a.outBottom && (this.$picker.addClass("am-datepicker-up"), i = t.top - this.$picker.outerHeight(!0))
				} else n = 0;
				this.$picker.css({
					top: i,
					left: n
				})
			}, a.prototype.update = function(t) {
				this.date = r.parseDate("string" == typeof t ? t : this.isInput ? this.$element.prop("value") : this.$element.data("date"), this.format), this.viewDate = new Date(this.date.getFullYear(), this.date.getMonth(), 1, 0, 0, 0, 0), this.fill()
			}, a.prototype.fillDow = function() {
				for(var t = this.weekStart, e = "<tr>"; t < this.weekStart + 7;) e += '<th class="am-datepicker-dow">' + a.locales[this.language].daysMin[t++ % 7] + "</th>";
				e += "</tr>", this.$picker.find(".am-datepicker-days thead").append(e)
			}, a.prototype.fillMonths = function() {
				for(var t = "", e = 0; 12 > e;) t += '<span class="am-datepicker-month">' + a.locales[this.language].monthsShort[e++] + "</span>";
				this.$picker.find(".am-datepicker-months td").append(t)
			}, a.prototype.fill = function() {
				var t = new Date(this.viewDate),
					e = t.getFullYear(),
					i = t.getMonth(),
					n = this.date.valueOf(),
					s = new Date(e, i - 1, 28, 0, 0, 0, 0),
					o = r.getDaysInMonth(s.getFullYear(), s.getMonth()),
					l = this.$picker.find(".am-datepicker-days .am-datepicker-select");
				l.text("zh_CN" === this.language ? e + a.locales[this.language].year[0] + " " + a.locales[this.language].months[i] : a.locales[this.language].months[i] + " " + e),
					s.setDate(o), s.setDate(o - (s.getDay() - this.weekStart + 7) % 7);
				var c = new Date(s);
				c.setDate(c.getDate() + 42), c = c.valueOf();
				for(var u, h, d, p = []; s.valueOf() < c;) s.getDay() === this.weekStart && p.push("<tr>"), u = this.onRender(s), h = s.getFullYear(), d = s.getMonth(), i > d && h === e || e > h ? u += " am-datepicker-old" : (d > i && h === e || h > e) && (u += " am-datepicker-new"), s.valueOf() === n && (u += " am-active"), p.push('<td class="am-datepicker-day ' + u + '">' + s.getDate() + "</td>"), s.getDay() === this.weekEnd && p.push("</tr>"), s.setDate(s.getDate() + 1);
				this.$picker.find(".am-datepicker-days tbody").empty().append(p.join(""));
				var m = this.date.getFullYear(),
					f = this.$picker.find(".am-datepicker-months").find(".am-datepicker-select").text(e);
				f = f.end().find("span").removeClass("am-active").removeClass("am-disabled");
				for(var v = 0; 12 > v;) this.onRender(t.setFullYear(e, v)) && f.eq(v).addClass("am-disabled"), v++;
				m === e && f.eq(this.date.getMonth()).removeClass("am-disabled").addClass("am-active"), p = "", e = 10 * parseInt(e / 10, 10);
				var g, w = this.$picker.find(".am-datepicker-years").find(".am-datepicker-select").text(e + "-" + (e + 9)).end().find("td");
				e -= 1;
				for(var y = -1; 11 > y; y++) g = this.onRender(t.setFullYear(e)), p += '<span class="' + g + (-1 === y || 10 === y ? " am-datepicker-old" : "") + (m === e ? " am-active" : "") + '">' + e + "</span>", e += 1;
				w.html(p)
			}, a.prototype.click = function(t) {
				t.stopPropagation(), t.preventDefault();
				var e, i, s = this.$picker.find(".am-datepicker-days").find(".am-active"),
					o = this.$picker.find(".am-datepicker-months"),
					a = o.find(".am-active").index(),
					l = n(t.target).closest("span, td, th");
				if(1 === l.length) switch(l[0].nodeName.toLowerCase()) {
					case "th":
						switch(l[0].className) {
							case "am-datepicker-switch":
								this.showMode(1);
								break;
							case "am-datepicker-prev":
							case "am-datepicker-next":
								this.viewDate["set" + r.modes[this.viewMode].navFnc].call(this.viewDate, this.viewDate["get" + r.modes[this.viewMode].navFnc].call(this.viewDate) + r.modes[this.viewMode].navStep * ("am-datepicker-prev" === l[0].className ? -1 : 1)), this.fill(), this.set()
						}
						break;
					case "span":
						if(l.is(".am-disabled")) return;
						l.is(".am-datepicker-month") ? (e = l.parent().find("span").index(l), l.is(".am-active") ? this.viewDate.setMonth(e, s.text()) : this.viewDate.setMonth(e)) : (i = parseInt(l.text(), 10) || 0, l.is(".am-active") ? this.viewDate.setFullYear(i, a, s.text()) : this.viewDate.setFullYear(i)), 0 !== this.viewMode && (this.date = new Date(this.viewDate), this.$element.trigger({
							type: "changeDate.datepicker.amui",
							date: this.date,
							viewMode: r.modes[this.viewMode].clsName
						})), this.showMode(-1), this.fill(), this.set();
						break;
					case "td":
						if(l.is(".am-datepicker-day") && !l.is(".am-disabled")) {
							var c = parseInt(l.text(), 10) || 1;
							e = this.viewDate.getMonth(), l.is(".am-datepicker-old") ? e -= 1 : l.is(".am-datepicker-new") && (e += 1), i = this.viewDate.getFullYear(), this.date = new Date(i, e, c, 0, 0, 0, 0), this.viewDate = new Date(i, e, Math.min(28, c), 0, 0, 0, 0), this.fill(), this.set(), this.$element.trigger({
								type: "changeDate.datepicker.amui",
								date: this.date,
								viewMode: r.modes[this.viewMode].clsName
							}), this.options.autoClose && this.close()
						}
				}
			}, a.prototype.mousedown = function(t) {
				t.stopPropagation(), t.preventDefault()
			}, a.prototype.showMode = function(t) {
				t && (this.viewMode = Math.max(this.minViewMode, Math.min(2, this.viewMode + t))), this.$picker.find(">div").hide().filter(".am-datepicker-" + r.modes[this.viewMode].clsName).show()
			}, a.prototype.isOutView = function() {
				var t = this.component ? this.component.offset() : this.$element.offset(),
					e = {
						outRight: !1,
						outBottom: !1
					},
					i = this.$picker,
					n = t.left + i.outerWidth(!0),
					s = t.top + i.outerHeight(!0) + this.$element.innerHeight();
				return n > o.width() && (e.outRight = !0), s > o.height() && (e.outBottom = !0), e
			}, a.prototype.getLocale = function(t) {
				return t || (t = navigator.language && navigator.language.split("-"), t[1] = t[1].toUpperCase(), t = t.join("_")), a.locales[t] || (t = "en_US"), t
			}, a.prototype.setTheme = function() {
				this.theme && this.$picker.addClass("am-datepicker-" + this.theme)
			}, a.locales = {
				en_US: {
					days: ["Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"],
					daysShort: ["Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"],
					daysMin: ["Su", "Mo", "Tu", "We", "Th", "Fr", "Sa"],
					months: ["January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"],
					monthsShort: ["Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"],
					weekStart: 0
				},
				zh_CN: {
					days: ["\u661f\u671f\u65e5", "\u661f\u671f\u4e00", "\u661f\u671f\u4e8c", "\u661f\u671f\u4e09", "\u661f\u671f\u56db", "\u661f\u671f\u4e94", "\u661f\u671f\u516d"],
					daysShort: ["\u5468\u65e5", "\u5468\u4e00", "\u5468\u4e8c", "\u5468\u4e09", "\u5468\u56db", "\u5468\u4e94", "\u5468\u516d"],
					daysMin: ["\u65e5", "\u4e00", "\u4e8c", "\u4e09", "\u56db", "\u4e94", "\u516d"],
					months: ["\u4e00\u6708", "\u4e8c\u6708", "\u4e09\u6708", "\u56db\u6708", "\u4e94\u6708", "\u516d\u6708", "\u4e03\u6708", "\u516b\u6708", "\u4e5d\u6708", "\u5341\u6708", "\u5341\u4e00\u6708", "\u5341\u4e8c\u6708"],
					monthsShort: ["\u4e00\u6708", "\u4e8c\u6708", "\u4e09\u6708", "\u56db\u6708", "\u4e94\u6708", "\u516d\u6708", "\u4e03\u6708", "\u516b\u6708", "\u4e5d\u6708", "\u5341\u6708", "\u5341\u4e00\u6708", "\u5341\u4e8c\u6708"],
					weekStart: 1,
					year: ["\u5e74"]
				}
			};
			var r = {
				modes: [{
					clsName: "days",
					navFnc: "Month",
					navStep: 1
				}, {
					clsName: "months",
					navFnc: "FullYear",
					navStep: 1
				}, {
					clsName: "years",
					navFnc: "FullYear",
					navStep: 10
				}],
				isLeapYear: function(t) {
					return t % 4 === 0 && t % 100 !== 0 || t % 400 === 0
				},
				getDaysInMonth: function(t, e) {
					return [31, r.isLeapYear(t) ? 29 : 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31][e]
				},
				parseFormat: function(t) {
					var e = t.match(/[.\/\-\s].*?/),
						i = t.split(/\W+/);
					if(!e || !i || 0 === i.length) throw new Error("Invalid date format.");
					return {
						separator: e,
						parts: i
					}
				},
				parseDate: function(t, e) {
					var i, n = t.split(e.separator);
					if(t = new Date, t.setHours(0), t.setMinutes(0), t.setSeconds(0), t.setMilliseconds(0), n.length === e.parts.length) {
						for(var s = t.getFullYear(), o = t.getDate(), a = t.getMonth(), r = 0, l = e.parts.length; l > r; r++) switch(i = parseInt(n[r], 10) || 1, e.parts[r]) {
							case "dd":
							case "d":
								o = i, t.setDate(i);
								break;
							case "mm":
							case "m":
								a = i - 1, t.setMonth(i - 1);
								break;
							case "yy":
								s = 2e3 + i, t.setFullYear(2e3 + i);
								break;
							case "yyyy":
								s = i, t.setFullYear(i)
						}
						t = new Date(s, a, o, 0, 0, 0)
					}
					return t
				},
				formatDate: function(t, e) {
					var i = {
							d: t.getDate(),
							m: t.getMonth() + 1,
							yy: t.getFullYear().toString().substring(2),
							yyyy: t.getFullYear()
						},
						n = [];
					i.dd = (i.d < 10 ? "0" : "") + i.d, i.mm = (i.m < 10 ? "0" : "") + i.m;
					for(var s = 0, o = e.parts.length; o > s; s++) n.push(i[e.parts[s]]);
					return n.join(e.separator)
				},
				headTemplate: '<thead><tr class="am-datepicker-header"><th class="am-datepicker-prev"><i class="am-datepicker-prev-icon"></i></th><th colspan="5" class="am-datepicker-switch"><div class="am-datepicker-select"></div></th><th class="am-datepicker-next"><i class="am-datepicker-next-icon"></i></th></tr></thead>',
				contTemplate: '<tbody><tr><td colspan="7"></td></tr></tbody>'
			};
			r.template = '<div class="am-datepicker am-datepicker-dropdown"><div class="am-datepicker-caret"></div><div class="am-datepicker-days"><table class="am-datepicker-table">' + r.headTemplate + '<tbody></tbody></table></div><div class="am-datepicker-months"><table class="am-datepicker-table">' + r.headTemplate + r.contTemplate + '</table></div><div class="am-datepicker-years"><table class="am-datepicker-table">' + r.headTemplate + r.contTemplate + "</table></div></div>", s.plugin("datepicker", a), s.ready(function(t) {
				n("[data-am-datepicker]").datepicker()
			}), e.exports = s.datepicker = a
		}, {
			2: 2
		}],
		8: [function(t, e, i) {
			"use strict";
			var n = window.jQuery,
				s = t(2),
				o = n(document),
				a = s.support.transition,
				r = function() {
					this.id = s.utils.generateGUID("am-dimmer"), this.$element = n(r.DEFAULTS.tpl, {
						id: this.id
					}), this.inited = !1, this.scrollbarWidth = 0, this.$used = n([])
				};
			r.DEFAULTS = {
				tpl: '<div class="am-dimmer" data-am-dimmer></div>'
			}, r.prototype.init = function() {
				return this.inited || (n(document.body).append(this.$element), this.inited = !0, o.trigger("init.dimmer.amui"), this.$element.on("touchmove.dimmer.amui", function(t) {
					t.preventDefault()
				})), this
			}, r.prototype.open = function(t) {
				this.inited || this.init();
				var e = this.$element;
				return t && (this.$used = this.$used.add(n(t))), this.checkScrollbar().setScrollbar(), e.show().trigger("open.dimmer.amui"), a && e.off(a.end), setTimeout(function() {
					e.addClass("am-active")
				}, 0), this
			}, r.prototype.close = function(t, e) {
				function i() {
					s.hide(), this.resetScrollbar()
				}
				if(this.$used = this.$used.not(n(t)), !e && this.$used.length) return this;
				var s = this.$element;
				return s.removeClass("am-active").trigger("close.dimmer.amui"), i.call(this), this
			}, r.prototype.checkScrollbar = function() {
				return this.scrollbarWidth = s.utils.measureScrollbar(), this
			}, r.prototype.setScrollbar = function() {
				var t = n(document.body),
					e = parseInt(t.css("padding-right") || 0, 10);
				return this.scrollbarWidth && t.css("padding-right", e + this.scrollbarWidth), t.addClass("am-dimmer-active"), this
			}, r.prototype.resetScrollbar = function() {
				return n(document.body).css("padding-right", "").removeClass("am-dimmer-active"), this
			}, e.exports = s.dimmer = new r
		}, {
			2: 2
		}],
		9: [function(t, e, i) {
			"use strict";
			var n = window.jQuery,
				s = t(2),
				o = s.support.animation,
				a = function(t, e) {
					this.options = n.extend({}, a.DEFAULTS, e), e = this.options, this.$element = n(t), this.$toggle = this.$element.find(e.selector.toggle), this.$dropdown = this.$element.find(e.selector.dropdown), this.$boundary = e.boundary === window ? n(window) : this.$element.closest(e.boundary), this.$justify = e.justify && n(e.justify).length && n(e.justify) || void 0, !this.$boundary.length && (this.$boundary = n(window)), this.active = this.$element.hasClass("am-active") ? !0 : !1, this.animating = null, this.events()
				};
			a.DEFAULTS = {
				animation: "am-animation-slide-top-fixed",
				boundary: window,
				justify: void 0,
				selector: {
					dropdown: ".am-dropdown-content",
					toggle: ".am-dropdown-toggle"
				},
				trigger: "click"
			}, a.prototype.toggle = function() {
				this.clear(), this.animating || this[this.active ? "close" : "open"]()
			}, a.prototype.open = function(t) {
				var e = this.$toggle,
					i = this.$element,
					s = this.$dropdown;
				if(!e.is(".am-disabled, :disabled") && !this.active) {
					i.trigger("open.dropdown.amui").addClass("am-active"), e.trigger("focus"), this.checkDimensions();
					var a = n.proxy(function() {
						i.trigger("opened.dropdown.amui"), this.active = !0, this.animating = 0
					}, this);
					o ? (this.animating = 1, s.addClass(this.options.animation).on(o.end + ".open.dropdown.amui", n.proxy(function() {
						a(), s.removeClass(this.options.animation)
					}, this))) : a()
				}
			}, a.prototype.close = function() {
				if(this.active) {
					var t = "am-dropdown-animation",
						e = this.$element,
						i = this.$dropdown;
					e.trigger("close.dropdown.amui");
					var s = n.proxy(function() {
						e.removeClass("am-active").trigger("closed.dropdown.amui"), this.active = !1, this.animating = 0, this.$toggle.blur()
					}, this);
					o ? (i.removeClass(this.options.animation), i.addClass(t), this.animating = 1, i.one(o.end + ".close.dropdown.amui", function() {
						i.removeClass(t), s()
					})) : s()
				}
			}, a.prototype.checkDimensions = function() {
				if(this.$dropdown.length) {
					var t = this.$dropdown,
						e = t.offset(),
						i = t.outerWidth(),
						s = this.$boundary.width(),
						o = n.isWindow(this.boundary) && this.$boundary.offset() ? this.$boundary.offset().left : 0;
					this.$justify && t.css({
						"min-width": this.$justify.css("width")
					}), i + (e.left - o) > s && this.$element.addClass("am-dropdown-flip")
				}
			}, a.prototype.clear = function() {
				n("[data-am-dropdown]").not(this.$element).each(function() {
					var t = n(this).data("amui.dropdown");
					t && t.close()
				})
			}, a.prototype.events = function() {
				var t = "dropdown.amui",
					e = this.$toggle;
				e.on("click." + t, n.proxy(function(t) {
					t.preventDefault(), this.toggle()
				}, this)), n(document).on("keydown.dropdown.amui", n.proxy(function(t) {
					27 === t.keyCode && this.active && this.close()
				}, this)).on("click.outer.dropdown.amui", n.proxy(function(t) {
					!this.active || this.$element[0] !== t.target && this.$element.find(t.target).length || this.close()
				}, this))
			}, s.plugin("dropdown", a), s.ready(function(t) {
				n("[data-am-dropdown]", t).dropdown()
			}), n(document).on("click.dropdown.amui.data-api", ".am-dropdown form", function(t) {
				t.stopPropagation()
			}), e.exports = s.dropdown = a
		}, {
			2: 2
		}],
		10: [function(t, e, i) {
			var n = window.jQuery,
				s = t(2);
			n.flexslider = function(t, e) {
				var i = n(t);
				i.vars = n.extend({}, n.flexslider.defaults, e);
				var s, o = i.vars.namespace,
					a = window.navigator && window.navigator.msPointerEnabled && window.MSGesture,
					r = ("ontouchstart" in window || a || window.DocumentTouch && document instanceof DocumentTouch) && i.vars.touch,
					l = "click touchend MSPointerUp keyup",
					c = "",
					u = "vertical" === i.vars.direction,
					h = i.vars.reverse,
					d = i.vars.itemWidth > 0,
					p = "fade" === i.vars.animation,
					m = "" !== i.vars.asNavFor,
					f = {},
					v = !0;
				n.data(t, "flexslider", i), f = {
					init: function() {
						i.animating = !1, i.currentSlide = parseInt(i.vars.startAt ? i.vars.startAt : 0, 10), isNaN(i.currentSlide) && (i.currentSlide = 0), i.animatingTo = i.currentSlide, i.atEnd = 0 === i.currentSlide || i.currentSlide === i.last, i.containerSelector = i.vars.selector.substr(0, i.vars.selector.search(" ")), i.slides = n(i.vars.selector, i), i.container = n(i.containerSelector, i), i.count = i.slides.length, i.syncExists = n(i.vars.sync).length > 0, "slide" === i.vars.animation && (i.vars.animation = "swing"), i.prop = u ? "top" : "marginLeft", i.args = {}, i.manualPause = !1, i.stopped = !1, i.started = !1, i.startTimeout = null, i.transitions = !i.vars.video && !p && i.vars.useCSS && function() {
							var t = document.createElement("div"),
								e = ["perspectiveProperty", "WebkitPerspective", "MozPerspective", "OPerspective", "msPerspective"];
							for(var n in e)
								if(void 0 !== t.style[e[n]]) return i.pfx = e[n].replace("Perspective", "").toLowerCase(), i.prop = "-" + i.pfx + "-transform", !0;
							return !1
						}(), i.ensureAnimationEnd = "", "" !== i.vars.controlsContainer && (i.controlsContainer = n(i.vars.controlsContainer).length > 0 && n(i.vars.controlsContainer)), "" !== i.vars.manualControls && (i.manualControls = n(i.vars.manualControls).length > 0 && n(i.vars.manualControls)), i.vars.randomize && (i.slides.sort(function() {
							return Math.round(Math.random()) - .5
						}), i.container.empty().append(i.slides)), i.doMath(), i.setup("init"), i.vars.controlNav && f.controlNav.setup(), i.vars.directionNav && f.directionNav.setup(), i.vars.keyboard && (1 === n(i.containerSelector).length || i.vars.multipleKeyboard) && n(document).bind("keyup", function(t) {
							var e = t.keyCode;
							if(!i.animating && (39 === e || 37 === e)) {
								var n = 39 === e ? i.getTarget("next") : 37 === e ? i.getTarget("prev") : !1;
								i.flexAnimate(n, i.vars.pauseOnAction)
							}
						}), i.vars.mousewheel && i.bind("mousewheel", function(t, e, n, s) {
							t.preventDefault();
							var o = i.getTarget(0 > e ? "next" : "prev");
							i.flexAnimate(o, i.vars.pauseOnAction)
						}), i.vars.pausePlay && f.pausePlay.setup(), i.vars.slideshow && i.vars.pauseInvisible && f.pauseInvisible.init(), i.vars.slideshow && (i.vars.pauseOnHover && i.hover(function() {
							i.manualPlay || i.manualPause || i.pause()
						}, function() {
							i.manualPause || i.manualPlay || i.stopped || i.play()
						}), i.vars.pauseInvisible && f.pauseInvisible.isHidden() || (i.vars.initDelay > 0 ? i.startTimeout = setTimeout(i.play, i.vars.initDelay) : i.play())), m && f.asNav.setup(), r && i.vars.touch && f.touch(), (!p || p && i.vars.smoothHeight) && n(window).bind("resize orientationchange focus", f.resize), i.find("img").attr("draggable", "false"), setTimeout(function() {
							i.vars.start(i)
						}, 200)
					},
					asNav: {
						setup: function() {
							i.asNav = !0, i.animatingTo = Math.floor(i.currentSlide / i.move), i.currentItem = i.currentSlide, i.slides.removeClass(o + "active-slide").eq(i.currentItem).addClass(o + "active-slide"), a ? (t._slider = i, i.slides.each(function() {
								var t = this;
								t._gesture = new MSGesture, t._gesture.target = t, t.addEventListener("MSPointerDown", function(t) {
									t.preventDefault(), t.currentTarget._gesture && t.currentTarget._gesture.addPointer(t.pointerId)
								}, !1), t.addEventListener("MSGestureTap", function(t) {
									t.preventDefault();
									var e = n(this),
										s = e.index();
									n(i.vars.asNavFor).data("flexslider").animating || e.hasClass("active") || (i.direction = i.currentItem < s ? "next" : "prev", i.flexAnimate(s, i.vars.pauseOnAction, !1, !0, !0))
								})
							})) : i.slides.on(l, function(t) {
								t.preventDefault();
								var e = n(this),
									s = e.index(),
									a = e.offset().left - n(i).scrollLeft();
								0 >= a && e.hasClass(o + "active-slide") ? i.flexAnimate(i.getTarget("prev"), !0) : n(i.vars.asNavFor).data("flexslider").animating || e.hasClass(o + "active-slide") || (i.direction = i.currentItem < s ? "next" : "prev", i.flexAnimate(s, i.vars.pauseOnAction, !1, !0, !0))
							})
						}
					},
					controlNav: {
						setup: function() {
							i.manualControls ? f.controlNav.setupManual() : f.controlNav.setupPaging()
						},
						setupPaging: function() {
							var t, e, s = "thumbnails" === i.vars.controlNav ? "control-thumbs" : "control-paging",
								a = 1;
							if(i.controlNavScaffold = n('<ol class="' + o + "control-nav " + o + s + '"></ol>'), i.pagingCount > 1)
								for(var r = 0; r < i.pagingCount; r++) {
									if(e = i.slides.eq(r), t = "thumbnails" === i.vars.controlNav ? '<img src="' + e.attr("data-thumb") + '"/>' : "<a>" + a + "</a>", "thumbnails" === i.vars.controlNav && !0 === i.vars.thumbCaptions) {
										var u = e.attr("data-thumbcaption");
										"" != u && void 0 != u && (t += '<span class="' + o + 'caption">' + u + "</span>")
									}
									i.controlNavScaffold.append("<li>" + t + "<i></i></li>"), a++
								}
							i.controlsContainer ? n(i.controlsContainer).append(i.controlNavScaffold) : i.append(i.controlNavScaffold), f.controlNav.set(), f.controlNav.active(), i.controlNavScaffold.delegate("a, img", l, function(t) {
								if(t.preventDefault(), "" === c || c === t.type) {
									var e = n(this),
										s = i.controlNav.index(e);
									e.hasClass(o + "active") || (i.direction = s > i.currentSlide ? "next" : "prev", i.flexAnimate(s, i.vars.pauseOnAction))
								}
								"" === c && (c = t.type), f.setToClearWatchedEvent()
							})
						},
						setupManual: function() {
							i.controlNav = i.manualControls, f.controlNav.active(), i.controlNav.bind(l, function(t) {
								if(t.preventDefault(), "" === c || c === t.type) {
									var e = n(this),
										s = i.controlNav.index(e);
									e.hasClass(o + "active") || (i.direction = s > i.currentSlide ? "next" : "prev", i.flexAnimate(s, i.vars.pauseOnAction))
								}
								"" === c && (c = t.type), f.setToClearWatchedEvent()
							})
						},
						set: function() {
							var t = "thumbnails" === i.vars.controlNav ? "img" : "a";
							i.controlNav = n("." + o + "control-nav li " + t, i.controlsContainer ? i.controlsContainer : i)
						},
						active: function() {
							i.controlNav.removeClass(o + "active").eq(i.animatingTo).addClass(o + "active")
						},
						update: function(t, e) {
							i.pagingCount > 1 && "add" === t ? i.controlNavScaffold.append(n("<li><a>" + i.count + "</a></li>")) : 1 === i.pagingCount ? i.controlNavScaffold.find("li").remove() : i.controlNav.eq(e).closest("li").remove(), f.controlNav.set(), i.pagingCount > 1 && i.pagingCount !== i.controlNav.length ? i.update(e, t) : f.controlNav.active()
						}
					},
					directionNav: {
						setup: function() {
							var t = n('<ul class="' + o + 'direction-nav"><li class="' + o + 'nav-prev"><a class="' + o + 'prev">' + i.vars.prevText + '</a></li><li class="' + o + 'nav-next"><a class="' + o + 'next">' + i.vars.nextText + "</a></li></ul>");
							i.controlsContainer ? (n(i.controlsContainer).append(t), i.directionNav = n("." + o + "direction-nav li a", i.controlsContainer)) : (i.append(t), i.directionNav = n("." + o + "direction-nav li a", i)), f.directionNav.update(), i.directionNav.bind(l, function(t) {
								t.preventDefault();
								var e;
								("" === c || c === t.type) && (e = i.getTarget(n(this).hasClass(o + "next") ? "next" : "prev"), i.flexAnimate(e, i.vars.pauseOnAction)), "" === c && (c = t.type), f.setToClearWatchedEvent()
							})
						},
						update: function() {
							var t = o + "disabled";
							1 === i.pagingCount ? i.directionNav.addClass(t).attr("tabindex", "-1") : i.vars.animationLoop ? i.directionNav.removeClass(t).removeAttr("tabindex") : 0 === i.animatingTo ? i.directionNav.removeClass(t).filter("." + o + "prev").addClass(t).attr("tabindex", "-1") : i.animatingTo === i.last ? i.directionNav.removeClass(t).filter("." + o + "next").addClass(t).attr("tabindex", "-1") : i.directionNav.removeClass(t).removeAttr("tabindex")
						}
					},
					pausePlay: {
						setup: function() {
							var t = n('<div class="' + o + 'pauseplay"><a></a></div>');
							i.controlsContainer ? (i.controlsContainer.append(t), i.pausePlay = n("." + o + "pauseplay a", i.controlsContainer)) : (i.append(t), i.pausePlay = n("." + o + "pauseplay a", i)), f.pausePlay.update(i.vars.slideshow ? o + "pause" : o + "play"), i.pausePlay.bind(l, function(t) {
								t.preventDefault(), ("" === c || c === t.type) && (n(this).hasClass(o + "pause") ? (i.manualPause = !0, i.manualPlay = !1, i.pause()) : (i.manualPause = !1, i.manualPlay = !0, i.play())), "" === c && (c = t.type), f.setToClearWatchedEvent()
							})
						},
						update: function(t) {
							"play" === t ? i.pausePlay.removeClass(o + "pause").addClass(o + "play").html(i.vars.playText) : i.pausePlay.removeClass(o + "play").addClass(o + "pause").html(i.vars.pauseText)
						}
					},
					touch: function() {
						function e(e) {
							i.animating ? e.preventDefault() : (window.navigator.msPointerEnabled || 1 === e.touches.length) && (i.pause(), v = u ? i.h : i.w, w = Number(new Date), b = e.touches[0].pageX, T = e.touches[0].pageY, f = d && h && i.animatingTo === i.last ? 0 : d && h ? i.limit - (i.itemW + i.vars.itemMargin) * i.move * i.animatingTo : d && i.currentSlide === i.last ? i.limit : d ? (i.itemW + i.vars.itemMargin) * i.move * i.currentSlide : h ? (i.last - i.currentSlide + i.cloneOffset) * v : (i.currentSlide + i.cloneOffset) * v, c = u ? T : b, m = u ? b : T, t.addEventListener("touchmove", n, !1), t.addEventListener("touchend", s, !1))
						}

						function n(t) {
							b = t.touches[0].pageX, T = t.touches[0].pageY, g = u ? c - T : c - b, y = u ? Math.abs(g) < Math.abs(b - m) : Math.abs(g) < Math.abs(T - m);
							var e = 500;
							(!y || Number(new Date) - w > e) && (t.preventDefault(), !p && i.transitions && (i.vars.animationLoop || (g /= 0 === i.currentSlide && 0 > g || i.currentSlide === i.last && g > 0 ? Math.abs(g) / v + 2 : 1), i.setProps(f + g, "setTouch")))
						}

						function s(e) {
							if(t.removeEventListener("touchmove", n, !1), i.animatingTo === i.currentSlide && !y && null !== g) {
								var o = h ? -g : g,
									a = i.getTarget(o > 0 ? "next" : "prev");
								i.canAdvance(a) && (Number(new Date) - w < 550 && Math.abs(o) > 50 || Math.abs(o) > v / 2) ? i.flexAnimate(a, i.vars.pauseOnAction) : p || i.flexAnimate(i.currentSlide, i.vars.pauseOnAction, !0)
							}
							t.removeEventListener("touchend", s, !1), c = null, m = null, g = null, f = null
						}

						function o(e) {
							e.stopPropagation(), i.animating ? e.preventDefault() : (i.pause(), t._gesture.addPointer(e.pointerId), x = 0, v = u ? i.h : i.w, w = Number(new Date), f = d && h && i.animatingTo === i.last ? 0 : d && h ? i.limit - (i.itemW + i.vars.itemMargin) * i.move * i.animatingTo : d && i.currentSlide === i.last ? i.limit : d ? (i.itemW + i.vars.itemMargin) * i.move * i.currentSlide : h ? (i.last - i.currentSlide + i.cloneOffset) * v : (i.currentSlide + i.cloneOffset) * v)
						}

						function r(e) {
							e.stopPropagation();
							var i = e.target._slider;
							if(i) {
								var n = -e.translationX,
									s = -e.translationY;
								return x += u ? s : n, g = x, y = u ? Math.abs(x) < Math.abs(-n) : Math.abs(x) < Math.abs(-s), e.detail === e.MSGESTURE_FLAG_INERTIA ? void setImmediate(function() {
									t._gesture.stop()
								}) : void((!y || Number(new Date) - w > 500) && (e.preventDefault(), !p && i.transitions && (i.vars.animationLoop || (g = x / (0 === i.currentSlide && 0 > x || i.currentSlide === i.last && x > 0 ? Math.abs(x) / v + 2 : 1)), i.setProps(f + g, "setTouch"))))
							}
						}

						function l(t) {
							t.stopPropagation();
							var e = t.target._slider;
							if(e) {
								if(e.animatingTo === e.currentSlide && !y && null !== g) {
									var i = h ? -g : g,
										n = e.getTarget(i > 0 ? "next" : "prev");
									e.canAdvance(n) && (Number(new Date) - w < 550 && Math.abs(i) > 50 || Math.abs(i) > v / 2) ? e.flexAnimate(n, e.vars.pauseOnAction) : p || e.flexAnimate(e.currentSlide, e.vars.pauseOnAction, !0)
								}
								c = null, m = null, g = null, f = null, x = 0
							}
						}
						var c, m, f, v, g, w, y = !1,
							b = 0,
							T = 0,
							x = 0;
						a ? (t.style.msTouchAction = "none", t._gesture = new MSGesture, t._gesture.target = t, t.addEventListener("MSPointerDown", o, !1), t._slider = i, t.addEventListener("MSGestureChange", r, !1), t.addEventListener("MSGestureEnd", l, !1)) : t.addEventListener("touchstart", e, !1)
					},
					resize: function() {
						!i.animating && i.is(":visible") && (d || i.doMath(), p ? f.smoothHeight() : d ? (i.slides.width(i.computedW), i.update(i.pagingCount), i.setProps()) : u ? (i.viewport.height(i.h), i.setProps(i.h, "setTotal")) : (i.vars.smoothHeight && f.smoothHeight(), i.newSlides.width(i.computedW), i.setProps(i.computedW, "setTotal")))
					},
					smoothHeight: function(t) {
						if(!u || p) {
							var e = p ? i : i.viewport;
							t ? e.animate({
								height: i.slides.eq(i.animatingTo).height()
							}, t) : e.height(i.slides.eq(i.animatingTo).height())
						}
					},
					sync: function(t) {
						var e = n(i.vars.sync).data("flexslider"),
							s = i.animatingTo;
						switch(t) {
							case "animate":
								e.flexAnimate(s, i.vars.pauseOnAction, !1, !0);
								break;
							case "play":
								e.playing || e.asNav || e.play();
								break;
							case "pause":
								e.pause()
						}
					},
					uniqueID: function(t) {
						return t.filter("[id]").add(t.find("[id]")).each(function() {
							var t = n(this);
							t.attr("id", t.attr("id") + "_clone")
						}), t
					},
					pauseInvisible: {
						visProp: null,
						init: function() {
							var t = f.pauseInvisible.getHiddenProp();
							if(t) {
								var e = t.replace(/[H|h]idden/, "") + "visibilitychange";
								document.addEventListener(e, function() {
									f.pauseInvisible.isHidden() ? i.startTimeout ? clearTimeout(i.startTimeout) : i.pause() : i.started ? i.play() : i.vars.initDelay > 0 ? setTimeout(i.play, i.vars.initDelay) : i.play()
								})
							}
						},
						isHidden: function() {
							var t = f.pauseInvisible.getHiddenProp();
							return t ? document[t] : !1
						},
						getHiddenProp: function() {
							var t = ["webkit", "moz", "ms", "o"];
							if("hidden" in document) return "hidden";
							for(var e = 0; e < t.length; e++)
								if(t[e] + "Hidden" in document) return t[e] + "Hidden";
							return null
						}
					},
					setToClearWatchedEvent: function() {
						clearTimeout(s), s = setTimeout(function() {
							c = ""
						}, 3e3)
					}
				}, i.flexAnimate = function(t, e, s, a, l) {
					if(i.vars.animationLoop || t === i.currentSlide || (i.direction = t > i.currentSlide ? "next" : "prev"), m && 1 === i.pagingCount && (i.direction = i.currentItem < t ? "next" : "prev"), !i.animating && (i.canAdvance(t, l) || s) && i.is(":visible")) {
						if(m && a) {
							var c = n(i.vars.asNavFor).data("flexslider");
							if(i.atEnd = 0 === t || t === i.count - 1, c.flexAnimate(t, !0, !1, !0, l), i.direction = i.currentItem < t ? "next" : "prev", c.direction = i.direction, Math.ceil((t + 1) / i.visible) - 1 === i.currentSlide || 0 === t) return i.currentItem = t, i.slides.removeClass(o + "active-slide").eq(t).addClass(o + "active-slide"), !1;
							i.currentItem = t, i.slides.removeClass(o + "active-slide").eq(t).addClass(o + "active-slide"), t = Math.floor(t / i.visible)
						}
						if(i.animating = !0, i.animatingTo = t, e && i.pause(), i.vars.before(i), i.syncExists && !l && f.sync("animate"), i.vars.controlNav && f.controlNav.active(), d || i.slides.removeClass(o + "active-slide").eq(t).addClass(o + "active-slide"), i.atEnd = 0 === t || t === i.last, i.vars.directionNav && f.directionNav.update(), t === i.last && (i.vars.end(i), i.vars.animationLoop || i.pause()), p) r ? (i.slides.eq(i.currentSlide).css({
							opacity: 0,
							zIndex: 1
						}), i.slides.eq(t).css({
							opacity: 1,
							zIndex: 2
						}), i.wrapup(y)) : (i.slides.eq(i.currentSlide).css({
							zIndex: 1
						}).animate({
							opacity: 0
						}, i.vars.animationSpeed, i.vars.easing), i.slides.eq(t).css({
							zIndex: 2
						}).animate({
							opacity: 1
						}, i.vars.animationSpeed, i.vars.easing, i.wrapup));
						else {
							var v, g, w, y = u ? i.slides.filter(":first").height() : i.computedW;
							d ? (v = i.vars.itemMargin, w = (i.itemW + v) * i.move * i.animatingTo, g = w > i.limit && 1 !== i.visible ? i.limit : w) : g = 0 === i.currentSlide && t === i.count - 1 && i.vars.animationLoop && "next" !== i.direction ? h ? (i.count + i.cloneOffset) * y : 0 : i.currentSlide === i.last && 0 === t && i.vars.animationLoop && "prev" !== i.direction ? h ? 0 : (i.count + 1) * y : h ? (i.count - 1 - t + i.cloneOffset) * y : (t + i.cloneOffset) * y, i.setProps(g, "", i.vars.animationSpeed), i.transitions ? (i.vars.animationLoop && i.atEnd || (i.animating = !1, i.currentSlide = i.animatingTo), i.container.unbind("webkitTransitionEnd transitionend"), i.container.bind("webkitTransitionEnd transitionend", function() {
								clearTimeout(i.ensureAnimationEnd), i.wrapup(y)
							}), clearTimeout(i.ensureAnimationEnd), i.ensureAnimationEnd = setTimeout(function() {
								i.wrapup(y)
							}, i.vars.animationSpeed + 100)) : i.container.animate(i.args, i.vars.animationSpeed, i.vars.easing, function() {
								i.wrapup(y)
							})
						}
						i.vars.smoothHeight && f.smoothHeight(i.vars.animationSpeed)
					}
				}, i.wrapup = function(t) {
					p || d || (0 === i.currentSlide && i.animatingTo === i.last && i.vars.animationLoop ? i.setProps(t, "jumpEnd") : i.currentSlide === i.last && 0 === i.animatingTo && i.vars.animationLoop && i.setProps(t, "jumpStart")), i.animating = !1, i.currentSlide = i.animatingTo, i.vars.after(i)
				}, i.animateSlides = function() {
					!i.animating && v && i.flexAnimate(i.getTarget("next"))
				}, i.pause = function() {
					clearInterval(i.animatedSlides), i.animatedSlides = null, i.playing = !1, i.vars.pausePlay && f.pausePlay.update("play"), i.syncExists && f.sync("pause")
				}, i.play = function() {
					i.playing && clearInterval(i.animatedSlides), i.animatedSlides = i.animatedSlides || setInterval(i.animateSlides, i.vars.slideshowSpeed), i.started = i.playing = !0, i.vars.pausePlay && f.pausePlay.update("pause"), i.syncExists && f.sync("play")
				}, i.stop = function() {
					i.pause(), i.stopped = !0
				}, i.canAdvance = function(t, e) {
					var n = m ? i.pagingCount - 1 : i.last;
					return e ? !0 : m && i.currentItem === i.count - 1 && 0 === t && "prev" === i.direction ? !0 : m && 0 === i.currentItem && t === i.pagingCount - 1 && "next" !== i.direction ? !1 : t !== i.currentSlide || m ? i.vars.animationLoop ? !0 : i.atEnd && 0 === i.currentSlide && t === n && "next" !== i.direction ? !1 : i.atEnd && i.currentSlide === n && 0 === t && "next" === i.direction ? !1 : !0 : !1
				}, i.getTarget = function(t) {
					return i.direction = t, "next" === t ? i.currentSlide === i.last ? 0 : i.currentSlide + 1 : 0 === i.currentSlide ? i.last : i.currentSlide - 1
				}, i.setProps = function(t, e, n) {
					var s = function() {
						var n = t ? t : (i.itemW + i.vars.itemMargin) * i.move * i.animatingTo,
							s = function() {
								if(d) return "setTouch" === e ? t : h && i.animatingTo === i.last ? 0 : h ? i.limit - (i.itemW + i.vars.itemMargin) * i.move * i.animatingTo : i.animatingTo === i.last ? i.limit : n;
								switch(e) {
									case "setTotal":
										return h ? (i.count - 1 - i.currentSlide + i.cloneOffset) * t : (i.currentSlide + i.cloneOffset) * t;
									case "setTouch":
										return h ? t : t;
									case "jumpEnd":
										return h ? t : i.count * t;
									case "jumpStart":
										return h ? i.count * t : t;
									default:
										return t
								}
							}();
						return -1 * s + "px"
					}();
					i.transitions && (s = u ? "translate3d(0," + s + ",0)" : "translate3d(" + s + ",0,0)", n = void 0 !== n ? n / 1e3 + "s" : "0s", i.container.css("-" + i.pfx + "-transition-duration", n), i.container.css("transition-duration", n)), i.args[i.prop] = s, (i.transitions || void 0 === n) && i.container.css(i.args), i.container.css("transform", s)
				}, i.setup = function(t) {
					if(p) i.slides.css({
						width: "100%",
						"float": "left",
						marginRight: "-100%",
						position: "relative"
					}), "init" === t && (r ? i.slides.css({
						opacity: 0,
						display: "block",
						webkitTransition: "opacity " + i.vars.animationSpeed / 1e3 + "s ease",
						zIndex: 1
					}).eq(i.currentSlide).css({
						opacity: 1,
						zIndex: 2
					}) : 0 == i.vars.fadeFirstSlide ? i.slides.css({
						opacity: 0,
						display: "block",
						zIndex: 1
					}).eq(i.currentSlide).css({
						zIndex: 2
					}).css({
						opacity: 1
					}) : i.slides.css({
						opacity: 0,
						display: "block",
						zIndex: 1
					}).eq(i.currentSlide).css({
						zIndex: 2
					}).animate({
						opacity: 1
					}, i.vars.animationSpeed, i.vars.easing)), i.vars.smoothHeight && f.smoothHeight();
					else {
						var e, s;
						"init" === t && (i.viewport = n('<div class="' + o + 'viewport"></div>').css({
							overflow: "hidden",
							position: "relative"
						}).appendTo(i).append(i.container), i.cloneCount = 0, i.cloneOffset = 0, h && (s = n.makeArray(i.slides).reverse(), i.slides = n(s), i.container.empty().append(i.slides))), i.vars.animationLoop && !d && (i.cloneCount = 2, i.cloneOffset = 1, "init" !== t && i.container.find(".clone").remove(), i.container.append(f.uniqueID(i.slides.first().clone().addClass("clone")).attr("aria-hidden", "true")).prepend(f.uniqueID(i.slides.last().clone().addClass("clone")).attr("aria-hidden", "true"))), i.newSlides = n(i.vars.selector, i), e = h ? i.count - 1 - i.currentSlide + i.cloneOffset : i.currentSlide + i.cloneOffset, u && !d ? (i.container.height(200 * (i.count + i.cloneCount) + "%").css("position", "absolute").width("100%"), setTimeout(function() {
							i.newSlides.css({
								display: "block"
							}), i.doMath(), i.viewport.height(i.h), i.setProps(e * i.h, "init")
						}, "init" === t ? 100 : 0)) : (i.container.width(200 * (i.count + i.cloneCount) + "%"), i.setProps(e * i.computedW, "init"), setTimeout(function() {
							i.doMath(), i.newSlides.css({
								width: i.computedW,
								"float": "left",
								display: "block"
							}), i.vars.smoothHeight && f.smoothHeight()
						}, "init" === t ? 100 : 0))
					}
					d || i.slides.removeClass(o + "active-slide").eq(i.currentSlide).addClass(o + "active-slide"), i.vars.init(i)
				}, i.doMath = function() {
					var t = i.slides.first(),
						e = i.vars.itemMargin,
						n = i.vars.minItems,
						s = i.vars.maxItems;
					i.w = void 0 === i.viewport ? i.width() : i.viewport.width(), i.h = t.height(), i.boxPadding = t.outerWidth() - t.width(), d ? (i.itemT = i.vars.itemWidth + e, i.minW = n ? n * i.itemT : i.w, i.maxW = s ? s * i.itemT - e : i.w, i.itemW = i.minW > i.w ? (i.w - e * (n - 1)) / n : i.maxW < i.w ? (i.w - e * (s - 1)) / s : i.vars.itemWidth > i.w ? i.w : i.vars.itemWidth, i.visible = Math.floor(i.w / i.itemW), i.move = i.vars.move > 0 && i.vars.move < i.visible ? i.vars.move : i.visible, i.pagingCount = Math.ceil((i.count - i.visible) / i.move + 1), i.last = i.pagingCount - 1, i.limit = 1 === i.pagingCount ? 0 : i.vars.itemWidth > i.w ? i.itemW * (i.count - 1) + e * (i.count - 1) : (i.itemW + e) * i.count - i.w - e) : (i.itemW = i.w, i.pagingCount = i.count, i.last = i.count - 1), i.computedW = i.itemW - i.boxPadding
				}, i.update = function(t, e) {
					i.doMath(), d || (t < i.currentSlide ? i.currentSlide += 1 : t <= i.currentSlide && 0 !== t && (i.currentSlide -= 1), i.animatingTo = i.currentSlide), i.vars.controlNav && !i.manualControls && ("add" === e && !d || i.pagingCount > i.controlNav.length ? f.controlNav.update("add") : ("remove" === e && !d || i.pagingCount < i.controlNav.length) && (d && i.currentSlide > i.last && (i.currentSlide -= 1, i.animatingTo -= 1), f.controlNav.update("remove", i.last))), i.vars.directionNav && f.directionNav.update()
				}, i.addSlide = function(t, e) {
					var s = n(t);
					i.count += 1, i.last = i.count - 1, u && h ? void 0 !== e ? i.slides.eq(i.count - e).after(s) : i.container.prepend(s) : void 0 !== e ? i.slides.eq(e).before(s) : i.container.append(s), i.update(e, "add"), i.slides = n(i.vars.selector + ":not(.clone)", i), i.setup(), i.vars.added(i)
				}, i.removeSlide = function(t) {
					var e = isNaN(t) ? i.slides.index(n(t)) : t;
					i.count -= 1, i.last = i.count - 1, isNaN(t) ? n(t, i.slides).remove() : u && h ? i.slides.eq(i.last).remove() : i.slides.eq(t).remove(), i.doMath(), i.update(e, "remove"), i.slides = n(i.vars.selector + ":not(.clone)", i), i.setup(), i.vars.removed(i)
				}, f.init()
			}, n(window).blur(function(t) {
				focused = !1
			}).focus(function(t) {
				focused = !0
			}), n.flexslider.defaults = {
				namespace: "am-",
				selector: ".am-slides > li",
				animation: "slide",
				easing: "swing",
				direction: "horizontal",
				reverse: !1,
				animationLoop: !0,
				smoothHeight: !1,
				startAt: 0,
				slideshow: !0,
				slideshowSpeed: 5e3,
				animationSpeed: 600,
				initDelay: 0,
				randomize: !1,
				fadeFirstSlide: !0,
				thumbCaptions: !1,
				pauseOnAction: !0,
				pauseOnHover: !1,
				pauseInvisible: !0,
				useCSS: !0,
				touch: !0,
				video: !1,
				controlNav: !0,
				directionNav: !0,
				prevText: " ",
				nextText: " ",
				keyboard: !0,
				multipleKeyboard: !1,
				mousewheel: !1,
				pausePlay: !1,
				pauseText: "Pause",
				playText: "Play",
				controlsContainer: "",
				manualControls: "",
				sync: "",
				asNavFor: "",
				itemWidth: 0,
				itemMargin: 0,
				minItems: 1,
				maxItems: 0,
				move: 0,
				allowOneSlide: !0,
				start: function() {},
				before: function() {},
				after: function() {},
				end: function() {},
				added: function() {},
				removed: function() {},
				init: function() {}
			}, n.fn.flexslider = function(t) {
				var e = Array.prototype.slice.call(arguments, 1);
				if(void 0 === t && (t = {}), "object" == typeof t) return this.each(function() {
					var e = n(this),
						i = t.selector ? t.selector : ".am-slides > li",
						s = e.find(i);
					1 === s.length && t.allowOneSlide === !0 || 0 === s.length ? (s.fadeIn(400), t.start && t.start(e)) : void 0 === e.data("flexslider") && new n.flexslider(this, t)
				});
				var i, s = n(this).data("flexslider");
				switch(t) {
					case "next":
						s.flexAnimate(s.getTarget("next"), !0);
						break;
					case "prev":
					case "previous":
						s.flexAnimate(s.getTarget("prev"), !0);
						break;
					default:
						"number" == typeof t ? s.flexAnimate(t, !0) : "string" == typeof t && (i = "function" == typeof s[t] ? s[t].apply(s, e) : s[t])
				}
				return void 0 === i ? this : i
			}, s.ready(function(t) {
				n("[data-am-flexslider]", t).each(function(t, e) {
					var i = n(e),
						o = s.utils.parseOptions(i.data("amFlexslider"));
					o.before = function(t) {
						t._pausedTimer && (window.clearTimeout(t._pausedTimer), t._pausedTimer = null)
					}, o.after = function(t) {
						var e = t.vars.playAfterPaused;
						!e || isNaN(e) || t.playing || t.manualPause || t.manualPlay || t.stopped || (t._pausedTimer = window.setTimeout(function() {
							t.play()
						}, e))
					}, i.flexslider(o)
				})
			}), e.exports = n.flexslider
		}, {
			2: 2
		}],
		11: [function(t, e, i) {
			"use strict";

			function n(t, e) {
				this.wrapper = "string" == typeof t ? document.querySelector(t) : t, this.scroller = this.wrapper.children[0], this.scrollerStyle = this.scroller.style, this.options = {
					startX: 0,
					startY: 0,
					scrollY: !0,
					directionLockThreshold: 5,
					momentum: !0,
					bounce: !0,
					bounceTime: 600,
					bounceEasing: "",
					preventDefault: !0,
					preventDefaultException: {
						tagName: /^(INPUT|TEXTAREA|BUTTON|SELECT)$/
					},
					HWCompositing: !0,
					useTransition: !0,
					useTransform: !0
				};
				for(var i in e) this.options[i] = e[i];
				this.translateZ = this.options.HWCompositing && a.hasPerspective ? " translateZ(0)" : "", this.options.useTransition = a.hasTransition && this.options.useTransition, this.options.useTransform = a.hasTransform && this.options.useTransform, this.options.eventPassthrough = this.options.eventPassthrough === !0 ? "vertical" : this.options.eventPassthrough, this.options.preventDefault = !this.options.eventPassthrough && this.options.preventDefault, this.options.scrollY = "vertical" == this.options.eventPassthrough ? !1 : this.options.scrollY, this.options.scrollX = "horizontal" == this.options.eventPassthrough ? !1 : this.options.scrollX, this.options.freeScroll = this.options.freeScroll && !this.options.eventPassthrough, this.options.directionLockThreshold = this.options.eventPassthrough ? 0 : this.options.directionLockThreshold, this.options.bounceEasing = "string" == typeof this.options.bounceEasing ? a.ease[this.options.bounceEasing] || a.ease.circular : this.options.bounceEasing, this.options.resizePolling = void 0 === this.options.resizePolling ? 60 : this.options.resizePolling, this.options.tap === !0 && (this.options.tap = "tap"), this.x = 0, this.y = 0, this.directionX = 0, this.directionY = 0, this._events = {}, this._init(), this.refresh(), this.scrollTo(this.options.startX, this.options.startY), this.enable()
			}
			var s = (window.jQuery, t(2)),
				o = window.requestAnimationFrame || window.webkitRequestAnimationFrame || window.mozRequestAnimationFrame || window.oRequestAnimationFrame || window.msRequestAnimationFrame || function(t) {
					window.setTimeout(t, 1e3 / 60)
				},
				a = function() {
					function t(t) {
						return n === !1 ? !1 : "" === n ? t : n + t.charAt(0).toUpperCase() + t.substr(1)
					}
					var e = {},
						i = document.createElement("div").style,
						n = function() {
							for(var t, e = ["t", "webkitT", "MozT", "msT", "OT"], n = 0, s = e.length; s > n; n++)
								if(t = e[n] + "ransform", t in i) return e[n].substr(0, e[n].length - 1);
							return !1
						}();
					e.getTime = Date.now || function() {
						return(new Date).getTime()
					}, e.extend = function(t, e) {
						for(var i in e) t[i] = e[i]
					}, e.addEvent = function(t, e, i, n) {
						t.addEventListener(e, i, !!n)
					}, e.removeEvent = function(t, e, i, n) {
						t.removeEventListener(e, i, !!n)
					}, e.prefixPointerEvent = function(t) {
						return window.MSPointerEvent ? "MSPointer" + t.charAt(9).toUpperCase() + t.substr(10) : t
					}, e.momentum = function(t, e, i, n, s, o) {
						var a, r, l = t - e,
							c = Math.abs(l) / i;
						return o = void 0 === o ? 6e-4 : o, a = t + c * c / (2 * o) * (0 > l ? -1 : 1), r = c / o, n > a ? (a = s ? n - s / 2.5 * (c / 8) : n, l = Math.abs(a - t), r = l / c) : a > 0 && (a = s ? s / 2.5 * (c / 8) : 0, l = Math.abs(t) + a, r = l / c), {
							destination: Math.round(a),
							duration: r
						}
					};
					var s = t("transform");
					return e.extend(e, {
						hasTransform: s !== !1,
						hasPerspective: t("perspective") in i,
						hasTouch: "ontouchstart" in window,
						hasPointer: window.PointerEvent || window.MSPointerEvent,
						hasTransition: t("transition") in i
					}), e.isBadAndroid = /Android /.test(window.navigator.appVersion) && !/Chrome\/\d/.test(window.navigator.appVersion), e.extend(e.style = {}, {
						transform: s,
						transitionTimingFunction: t("transitionTimingFunction"),
						transitionDuration: t("transitionDuration"),
						transitionDelay: t("transitionDelay"),
						transformOrigin: t("transformOrigin")
					}), e.hasClass = function(t, e) {
						var i = new RegExp("(^|\\s)" + e + "(\\s|$)");
						return i.test(t.className)
					}, e.addClass = function(t, i) {
						if(!e.hasClass(t, i)) {
							var n = t.className.split(" ");
							n.push(i), t.className = n.join(" ")
						}
					}, e.removeClass = function(t, i) {
						if(e.hasClass(t, i)) {
							var n = new RegExp("(^|\\s)" + i + "(\\s|$)", "g");
							t.className = t.className.replace(n, " ")
						}
					}, e.offset = function(t) {
						for(var e = -t.offsetLeft, i = -t.offsetTop; t = t.offsetParent;) e -= t.offsetLeft, i -= t.offsetTop;
						return {
							left: e,
							top: i
						}
					}, e.preventDefaultException = function(t, e) {
						for(var i in e)
							if(e[i].test(t[i])) return !0;
						return !1
					}, e.extend(e.eventType = {}, {
						touchstart: 1,
						touchmove: 1,
						touchend: 1,
						mousedown: 2,
						mousemove: 2,
						mouseup: 2,
						pointerdown: 3,
						pointermove: 3,
						pointerup: 3,
						MSPointerDown: 3,
						MSPointerMove: 3,
						MSPointerUp: 3
					}), e.extend(e.ease = {}, {
						quadratic: {
							style: "cubic-bezier(0.25, 0.46, 0.45, 0.94)",
							fn: function(t) {
								return t * (2 - t)
							}
						},
						circular: {
							style: "cubic-bezier(0.1, 0.57, 0.1, 1)",
							fn: function(t) {
								return Math.sqrt(1 - --t * t)
							}
						},
						back: {
							style: "cubic-bezier(0.175, 0.885, 0.32, 1.275)",
							fn: function(t) {
								var e = 4;
								return(t -= 1) * t * ((e + 1) * t + e) + 1
							}
						},
						bounce: {
							style: "",
							fn: function(t) {
								return(t /= 1) < 1 / 2.75 ? 7.5625 * t * t : 2 / 2.75 > t ? 7.5625 * (t -= 1.5 / 2.75) * t + .75 : 2.5 / 2.75 > t ? 7.5625 * (t -= 2.25 / 2.75) * t + .9375 : 7.5625 * (t -= 2.625 / 2.75) * t + .984375
							}
						},
						elastic: {
							style: "",
							fn: function(t) {
								var e = .22,
									i = .4;
								return 0 === t ? 0 : 1 == t ? 1 : i * Math.pow(2, -10 * t) * Math.sin(2 * (t - e / 4) * Math.PI / e) + 1
							}
						}
					}), e.tap = function(t, e) {
						var i = document.createEvent("Event");
						i.initEvent(e, !0, !0), i.pageX = t.pageX, i.pageY = t.pageY, t.target.dispatchEvent(i)
					}, e.click = function(t) {
						var e, i = t.target;
						/(SELECT|INPUT|TEXTAREA)/i.test(i.tagName) || (e = document.createEvent("MouseEvents"), e.initMouseEvent("click", !0, !0, t.view, 1, i.screenX, i.screenY, i.clientX, i.clientY, t.ctrlKey, t.altKey, t.shiftKey, t.metaKey, 0, null), e._constructed = !0, i.dispatchEvent(e))
					}, e
				}();
			n.prototype = {
				version: "5.1.3",
				_init: function() {
					this._initEvents()
				},
				destroy: function() {
					this._initEvents(!0), this._execEvent("destroy")
				},
				_transitionEnd: function(t) {
					t.target == this.scroller && this.isInTransition && (this._transitionTime(), this.resetPosition(this.options.bounceTime) || (this.isInTransition = !1, this._execEvent("scrollEnd")))
				},
				_start: function(t) {
					if(!(1 != a.eventType[t.type] && 0 !== t.button || !this.enabled || this.initiated && a.eventType[t.type] !== this.initiated)) {
						!this.options.preventDefault || a.isBadAndroid || a.preventDefaultException(t.target, this.options.preventDefaultException) || t.preventDefault();
						var e, i = t.touches ? t.touches[0] : t;
						this.initiated = a.eventType[t.type], this.moved = !1, this.distX = 0, this.distY = 0, this.directionX = 0, this.directionY = 0, this.directionLocked = 0, this._transitionTime(), this.startTime = a.getTime(), this.options.useTransition && this.isInTransition ? (this.isInTransition = !1, e = this.getComputedPosition(), this._translate(Math.round(e.x), Math.round(e.y)), this._execEvent("scrollEnd")) : !this.options.useTransition && this.isAnimating && (this.isAnimating = !1, this._execEvent("scrollEnd")), this.startX = this.x, this.startY = this.y, this.absStartX = this.x, this.absStartY = this.y, this.pointX = i.pageX, this.pointY = i.pageY, this._execEvent("beforeScrollStart")
					}
				},
				_move: function(t) {
					if(this.enabled && a.eventType[t.type] === this.initiated) {
						this.options.preventDefault && t.preventDefault();
						var e, i, n, s, o = t.touches ? t.touches[0] : t,
							r = o.pageX - this.pointX,
							l = o.pageY - this.pointY,
							c = a.getTime();
						if(this.pointX = o.pageX, this.pointY = o.pageY, this.distX += r, this.distY += l, n = Math.abs(this.distX), s = Math.abs(this.distY), !(c - this.endTime > 300 && 10 > n && 10 > s)) {
							if(this.directionLocked || this.options.freeScroll || (this.directionLocked = n > s + this.options.directionLockThreshold ? "h" : s >= n + this.options.directionLockThreshold ? "v" : "n"), "h" == this.directionLocked) {
								if("vertical" == this.options.eventPassthrough) t.preventDefault();
								else if("horizontal" == this.options.eventPassthrough) return void(this.initiated = !1);
								l = 0
							} else if("v" == this.directionLocked) {
								if("horizontal" == this.options.eventPassthrough) t.preventDefault();
								else if("vertical" == this.options.eventPassthrough) return void(this.initiated = !1);
								r = 0
							}
							r = this.hasHorizontalScroll ? r : 0, l = this.hasVerticalScroll ? l : 0, e = this.x + r, i = this.y + l, (e > 0 || e < this.maxScrollX) && (e = this.options.bounce ? this.x + r / 3 : e > 0 ? 0 : this.maxScrollX), (i > 0 || i < this.maxScrollY) && (i = this.options.bounce ? this.y + l / 3 : i > 0 ? 0 : this.maxScrollY), this.directionX = r > 0 ? -1 : 0 > r ? 1 : 0, this.directionY = l > 0 ? -1 : 0 > l ? 1 : 0, this.moved || this._execEvent("scrollStart"), this.moved = !0, this._translate(e, i), c - this.startTime > 300 && (this.startTime = c, this.startX = this.x, this.startY = this.y)
						}
					}
				},
				_end: function(t) {
					if(this.enabled && a.eventType[t.type] === this.initiated) {
						this.options.preventDefault && !a.preventDefaultException(t.target, this.options.preventDefaultException) && t.preventDefault();
						var e, i, n = (t.changedTouches ? t.changedTouches[0] : t, a.getTime() - this.startTime),
							s = Math.round(this.x),
							o = Math.round(this.y),
							r = Math.abs(s - this.startX),
							l = Math.abs(o - this.startY),
							c = 0,
							u = "";
						if(this.isInTransition = 0, this.initiated = 0, this.endTime = a.getTime(), !this.resetPosition(this.options.bounceTime)) return this.scrollTo(s, o), this.moved ? this._events.flick && 200 > n && 100 > r && 100 > l ? void this._execEvent("flick") : (this.options.momentum && 300 > n && (e = this.hasHorizontalScroll ? a.momentum(this.x, this.startX, n, this.maxScrollX, this.options.bounce ? this.wrapperWidth : 0, this.options.deceleration) : {
							destination: s,
							duration: 0
						}, i = this.hasVerticalScroll ? a.momentum(this.y, this.startY, n, this.maxScrollY, this.options.bounce ? this.wrapperHeight : 0, this.options.deceleration) : {
							destination: o,
							duration: 0
						}, s = e.destination, o = i.destination, c = Math.max(e.duration, i.duration), this.isInTransition = 1), s != this.x || o != this.y ? ((s > 0 || s < this.maxScrollX || o > 0 || o < this.maxScrollY) && (u = a.ease.quadratic), void this.scrollTo(s, o, c, u)) : void this._execEvent("scrollEnd")) : (this.options.tap && a.tap(t, this.options.tap), this.options.click && a.click(t), void this._execEvent("scrollCancel"))
					}
				},
				_resize: function() {
					var t = this;
					clearTimeout(this.resizeTimeout), this.resizeTimeout = setTimeout(function() {
						t.refresh()
					}, this.options.resizePolling)
				},
				resetPosition: function(t) {
					var e = this.x,
						i = this.y;
					return t = t || 0, !this.hasHorizontalScroll || this.x > 0 ? e = 0 : this.x < this.maxScrollX && (e = this.maxScrollX), !this.hasVerticalScroll || this.y > 0 ? i = 0 : this.y < this.maxScrollY && (i = this.maxScrollY), e == this.x && i == this.y ? !1 : (this.scrollTo(e, i, t, this.options.bounceEasing), !0)
				},
				disable: function() {
					this.enabled = !1
				},
				enable: function() {
					this.enabled = !0
				},
				refresh: function() {
					this.wrapper.offsetHeight;
					this.wrapperWidth = this.wrapper.clientWidth, this.wrapperHeight = this.wrapper.clientHeight, this.scrollerWidth = this.scroller.offsetWidth, this.scrollerHeight = this.scroller.offsetHeight, this.maxScrollX = this.wrapperWidth - this.scrollerWidth, this.maxScrollY = this.wrapperHeight - this.scrollerHeight, this.hasHorizontalScroll = this.options.scrollX && this.maxScrollX < 0, this.hasVerticalScroll = this.options.scrollY && this.maxScrollY < 0, this.hasHorizontalScroll || (this.maxScrollX = 0, this.scrollerWidth = this.wrapperWidth), this.hasVerticalScroll || (this.maxScrollY = 0, this.scrollerHeight = this.wrapperHeight), this.endTime = 0, this.directionX = 0, this.directionY = 0, this.wrapperOffset = a.offset(this.wrapper), this._execEvent("refresh"), this.resetPosition()
				},
				on: function(t, e) {
					this._events[t] || (this._events[t] = []), this._events[t].push(e)
				},
				off: function(t, e) {
					if(this._events[t]) {
						var i = this._events[t].indexOf(e);
						i > -1 && this._events[t].splice(i, 1)
					}
				},
				_execEvent: function(t) {
					if(this._events[t]) {
						var e = 0,
							i = this._events[t].length;
						if(i)
							for(; i > e; e++) this._events[t][e].apply(this, [].slice.call(arguments, 1))
					}
				},
				scrollBy: function(t, e, i, n) {
					t = this.x + t, e = this.y + e, i = i || 0, this.scrollTo(t, e, i, n)
				},
				scrollTo: function(t, e, i, n) {
					n = n || a.ease.circular, this.isInTransition = this.options.useTransition && i > 0, !i || this.options.useTransition && n.style ? (this._transitionTimingFunction(n.style), this._transitionTime(i), this._translate(t, e)) : this._animate(t, e, i, n.fn)
				},
				scrollToElement: function(t, e, i, n, s) {
					if(t = t.nodeType ? t : this.scroller.querySelector(t)) {
						var o = a.offset(t);
						o.left -= this.wrapperOffset.left, o.top -= this.wrapperOffset.top, i === !0 && (i = Math.round(t.offsetWidth / 2 - this.wrapper.offsetWidth / 2)), n === !0 && (n = Math.round(t.offsetHeight / 2 - this.wrapper.offsetHeight / 2)), o.left -= i || 0, o.top -= n || 0, o.left = o.left > 0 ? 0 : o.left < this.maxScrollX ? this.maxScrollX : o.left, o.top = o.top > 0 ? 0 : o.top < this.maxScrollY ? this.maxScrollY : o.top, e = void 0 === e || null === e || "auto" === e ? Math.max(Math.abs(this.x - o.left), Math.abs(this.y - o.top)) : e, this.scrollTo(o.left, o.top, e, s)
					}
				},
				_transitionTime: function(t) {
					t = t || 0, this.scrollerStyle[a.style.transitionDuration] = t + "ms", !t && a.isBadAndroid && (this.scrollerStyle[a.style.transitionDuration] = "0.001s")
				},
				_transitionTimingFunction: function(t) {
					this.scrollerStyle[a.style.transitionTimingFunction] = t
				},
				_translate: function(t, e) {
					this.options.useTransform ? this.scrollerStyle[a.style.transform] = "translate(" + t + "px," + e + "px)" + this.translateZ : (t = Math.round(t), e = Math.round(e), this.scrollerStyle.left = t + "px", this.scrollerStyle.top = e + "px"), this.x = t, this.y = e
				},
				_initEvents: function(t) {
					var e = t ? a.removeEvent : a.addEvent,
						i = this.options.bindToWrapper ? this.wrapper : window;
					e(window, "orientationchange", this), e(window, "resize", this), this.options.click && e(this.wrapper, "click", this, !0), this.options.disableMouse || (e(this.wrapper, "mousedown", this), e(i, "mousemove", this), e(i, "mousecancel", this), e(i, "mouseup", this)), a.hasPointer && !this.options.disablePointer && (e(this.wrapper, a.prefixPointerEvent("pointerdown"), this), e(i, a.prefixPointerEvent("pointermove"), this), e(i, a.prefixPointerEvent("pointercancel"), this), e(i, a.prefixPointerEvent("pointerup"), this)), a.hasTouch && !this.options.disableTouch && (e(this.wrapper, "touchstart", this), e(i, "touchmove", this), e(i, "touchcancel", this), e(i, "touchend", this)), e(this.scroller, "transitionend", this), e(this.scroller, "webkitTransitionEnd", this), e(this.scroller, "oTransitionEnd", this), e(this.scroller, "MSTransitionEnd", this)
				},
				getComputedPosition: function() {
					var t, e, i = window.getComputedStyle(this.scroller, null);
					return this.options.useTransform ? (i = i[a.style.transform].split(")")[0].split(", "), t = +(i[12] || i[4]), e = +(i[13] || i[5])) : (t = +i.left.replace(/[^-\d.]/g, ""), e = +i.top.replace(/[^-\d.]/g, "")), {
						x: t,
						y: e
					}
				},
				_animate: function(t, e, i, n) {
					function s() {
						var d, p, m, f = a.getTime();
						return f >= h ? (r.isAnimating = !1, r._translate(t, e), void(r.resetPosition(r.options.bounceTime) || r._execEvent("scrollEnd"))) : (f = (f - u) / i, m = n(f), d = (t - l) * m + l, p = (e - c) * m + c, r._translate(d, p), void(r.isAnimating && o(s)))
					}
					var r = this,
						l = this.x,
						c = this.y,
						u = a.getTime(),
						h = u + i;
					this.isAnimating = !0, s()
				},
				handleEvent: function(t) {
					switch(t.type) {
						case "touchstart":
						case "pointerdown":
						case "MSPointerDown":
						case "mousedown":
							this._start(t);
							break;
						case "touchmove":
						case "pointermove":
						case "MSPointerMove":
						case "mousemove":
							this._move(t);
							break;
						case "touchend":
						case "pointerup":
						case "MSPointerUp":
						case "mouseup":
						case "touchcancel":
						case "pointercancel":
						case "MSPointerCancel":
						case "mousecancel":
							this._end(t);
							break;
						case "orientationchange":
						case "resize":
							this._resize();
							break;
						case "transitionend":
						case "webkitTransitionEnd":
						case "oTransitionEnd":
						case "MSTransitionEnd":
							this._transitionEnd(t);
							break;
						case "wheel":
						case "DOMMouseScroll":
						case "mousewheel":
							this._wheel(t);
							break;
						case "keydown":
							this._key(t);
							break;
						case "click":
							t._constructed || (t.preventDefault(), t.stopPropagation())
					}
				}
			}, n.utils = a, e.exports = s.iScroll = n
		}, {
			2: 2
		}],
		12: [function(t, e, i) {
			"use strict";

			function n(t, e) {
				return this.each(function() {
					var i = s(this),
						n = i.data("amui.modal"),
						o = "object" == typeof t && t;
					n || i.data("amui.modal", n = new c(this, o)), "string" == typeof t ? n[t] && n[t](e) : n.toggle(t && t.relatedTarget || void 0)
				})
			}
			var s = window.jQuery,
				o = t(2),
				a = t(8),
				r = s(document),
				l = o.support.transition,
				c = function(t, e) {
					this.options = s.extend({}, c.DEFAULTS, e || {}), this.$element = s(t), this.$dialog = this.$element.find(".am-modal-dialog"), this.$element.attr("id") || this.$element.attr("id", o.utils.generateGUID("am-modal")), this.isPopup = this.$element.hasClass("am-popup"), this.isActions = this.$element.hasClass("am-modal-actions"), this.isPrompt = this.$element.hasClass("am-modal-prompt"), this.isLoading = this.$element.hasClass("am-modal-loading"), this.active = this.transitioning = this.relatedTarget = null, this.events()
				};
			c.DEFAULTS = {
				className: {
					active: "am-modal-active",
					out: "am-modal-out"
				},
				selector: {
					modal: ".am-modal",
					active: ".am-modal-active"
				},
				closeViaDimmer: !0,
				cancelable: !0,
				onConfirm: function() {},
				onCancel: function() {},
				closeOnCancel: !0,
				closeOnConfirm: !0,
				height: void 0,
				width: void 0,
				duration: 300,
				transitionEnd: l && l.end + ".modal.amui"
			}, c.prototype.toggle = function(t) {
				return this.active ? this.close() : this.open(t)
			}, c.prototype.open = function(t) {
				var e = this.$element,
					i = this.options,
					n = this.isPopup,
					o = i.width,
					r = i.height,
					c = {};
				if(!this.active && this.$element.length) {
					t && (this.relatedTarget = t), this.transitioning && (clearTimeout(e.transitionEndTimmer), e.transitionEndTimmer = null, e.trigger(i.transitionEnd).off(i.transitionEnd)), n && this.$element.show(), this.active = !0, e.trigger(s.Event("open.modal.amui", {
						relatedTarget: t
					})), a.open(e), e.show().redraw(), n || this.isActions || (o && (o = parseInt(o, 10), c.width = o + "px", c.marginLeft = -parseInt(o / 2) + "px"), r ? (r = parseInt(r, 10), c.marginTop = -parseInt(r / 2) + "px", this.$dialog.css({
						height: r + "px"
					})) : c.marginTop = -parseInt(e.height() / 2, 10) + "px", e.css(c)), e.removeClass(i.className.out).addClass(i.className.active), this.transitioning = 1;
					var u = function() {
						e.trigger(s.Event("opened.modal.amui", {
							relatedTarget: t
						})), this.transitioning = 0, this.isPrompt && this.$dialog.find("input").eq(0).focus()
					};
					return l ? void e.one(i.transitionEnd, s.proxy(u, this)).emulateTransitionEnd(i.duration) : u.call(this)
				}
			}, c.prototype.close = function(t) {
				if(this.active) {
					var e = this.$element,
						i = this.options,
						n = this.isPopup;
					this.transitioning && (clearTimeout(e.transitionEndTimmer), e.transitionEndTimmer = null, e.trigger(i.transitionEnd).off(i.transitionEnd), a.close(e, !0)), this.$element.trigger(s.Event("close.modal.amui", {
						relatedTarget: t
					})), this.transitioning = 1;
					var o = function() {
						e.trigger("closed.modal.amui"), n && e.removeClass(i.className.out), e.hide(), this.transitioning = 0, a.close(e, !1), this.active = !1
					};
					return e.removeClass(i.className.active).addClass(i.className.out), l ? void e.one(i.transitionEnd, s.proxy(o, this)).emulateTransitionEnd(i.duration) : o.call(this)
				}
			}, c.prototype.events = function() {
				var t = this.options,
					e = this,
					i = this.$element,
					n = i.find(".am-modal-prompt-input"),
					o = i.find("[data-am-modal-confirm]"),
					r = i.find("[data-am-modal-cancel]"),
					l = function() {
						var t = [];
						return n.each(function() {
							t.push(s(this).val())
						}), 0 === t.length ? void 0 : 1 === t.length ? t[0] : t
					};
				this.options.cancelable && i.on("keyup.modal.amui", function(t) {
					e.active && 27 === t.which && (i.trigger("cancel.modal.amui"), e.close())
				}), this.options.closeViaDimmer && !this.isLoading && a.$element.on("click.dimmer.modal.amui", function(t) {
					e.close()
				}), i.find("[data-am-modal-close], .am-modal-btn").on("click.close.modal.amui", function(i) {
					i.preventDefault();
					var n = s(this);
					n.is(o) ? (console.log("sdafdf"), t.closeOnConfirm && e.close()) : n.is(r) ? t.closeOnCancel && e.close() : e.close()
				}), o.on("click.confirm.modal.amui", function() {
					i.trigger(s.Event("confirm.modal.amui", {
						trigger: this
					}))
				}), r.on("click.cancel.modal.amui", function() {
					i.trigger(s.Event("cancel.modal.amui", {
						trigger: this
					}))
				}), i.on("confirm.modal.amui", function(t) {
					t.data = l(), e.options.onConfirm.call(e, t)
				}).on("cancel.modal.amui", function(t) {
					t.data = l(), e.options.onCancel.call(e, t)
				})
			}, s.fn.modal = n, r.on("click.modal.amui.data-api", "[data-am-modal]", function() {
				var t = s(this),
					e = o.utils.parseOptions(t.attr("data-am-modal")),
					i = s(e.target || this.href && this.href.replace(/.*(?=#[^\s]+$)/, "")),
					a = i.data("amui.modal") ? "toggle" : e;
				n.call(i, a, this)
			}), e.exports = o.modal = c
		}, {
			2: 2,
			8: 8
		}],
		13: [function(t, e, i) {
			"use strict";

			function n(t, e) {
				var i = Array.prototype.slice.call(arguments, 1);
				return this.each(function() {
					var n = s(this),
						o = n.data("amui.offcanvas"),
						a = s.extend({}, "object" == typeof t && t);
					o || (n.data("amui.offcanvas", o = new c(this, a)), (!t || "object" == typeof t) && o.open(e)), "string" == typeof t && o[t] && o[t].apply(o, i)
				})
			}
			var s = window.jQuery,
				o = t(2);
			t(30);
			var a, r = s(window),
				l = s(document),
				c = function(t, e) {
					this.$element = s(t), this.options = s.extend({}, c.DEFAULTS, e), this.active = null, this.bindEvents()
				};
			c.DEFAULTS = {
				duration: 300,
				effect: "overlay"
			}, c.prototype.open = function(t) {
				var e = this,
					i = this.$element;
				if(i.length && !i.hasClass("am-active")) {
					var n = this.options.effect,
						o = s("html"),
						l = s("body"),
						c = i.find(".am-offcanvas-bar").first(),
						u = c.hasClass("am-offcanvas-bar-flip") ? -1 : 1;
					c.addClass("am-offcanvas-bar-" + n), a = {
						x: window.scrollX,
						y: window.scrollY
					}, i.addClass("am-active"), l.css({
						width: window.innerWidth,
						height: r.height()
					}).addClass("am-offcanvas-page"), "overlay" !== n && l.css({
						"margin-left": c.outerWidth() * u
					}).width(), o.css("margin-top", -1 * a.y), setTimeout(function() {
						c.addClass("am-offcanvas-bar-active").width()
					}, 0), i.trigger("open.offcanvas.amui"), this.active = 1, i.on("click.offcanvas.amui", function(t) {
						var i = s(t.target);
						i.hasClass("am-offcanvas-bar") || i.parents(".am-offcanvas-bar").first().length || (t.stopImmediatePropagation(), e.close())
					}), o.on("keydown.offcanvas.amui", function(t) {
						27 === t.keyCode && e.close()
					})
				}
			}, c.prototype.close = function(t) {
				function e() {
					r.removeClass("am-offcanvas-page").css({
						width: "",
						height: "",
						"margin-left": "",
						"margin-right": ""
					}), l.removeClass("am-active"), c.removeClass("am-offcanvas-bar-active"), n.css("margin-top", ""), window.scrollTo(a.x, a.y), l.trigger("closed.offcanvas.amui"), i.active = 0
				}
				var i = this,
					n = s("html"),
					r = s("body"),
					l = this.$element,
					c = l.find(".am-offcanvas-bar").first();
				l.length && this.active && l.hasClass("am-active") && (l.trigger("close.offcanvas.amui"), o.support.transition ? (setTimeout(function() {
					c.removeClass("am-offcanvas-bar-active")
				}, 0), r.css("margin-left", "").one(o.support.transition.end, function() {
					e()
				}).emulateTransitionEnd(this.options.duration)) : e(), l.off("click.offcanvas.amui"), n.off(".offcanvas.amui"))
			}, c.prototype.bindEvents = function() {
				var t = this;
				return l.on("click.offcanvas.amui", '[data-am-dismiss="offcanvas"]', function(e) {
					e.preventDefault(), t.close()
				}), r.on("resize.offcanvas.amui orientationchange.offcanvas.amui", function() {
					t.active && t.close()
				}), this.$element.hammer().on("swipeleft swipeleft", function(e) {
					e.preventDefault(), t.close()
				}), this
			}, s.fn.offCanvas = n, l.on("click.offcanvas.amui", "[data-am-offcanvas]", function(t) {
				t.preventDefault();
				var e = s(this),
					i = o.utils.parseOptions(e.data("amOffcanvas")),
					a = s(i.target || this.href && this.href.replace(/.*(?=#[^\s]+$)/, "")),
					r = a.data("amui.offcanvas") ? "open" : i;
				n.call(a, r, this)
			}), e.exports = o.offcanvas = c
		}, {
			2: 2,
			30: 30
		}],
		14: [function(t, e, i) {
			"use strict";
			var n = window.jQuery,
				s = t(2),
				o = function(t) {
					var e = function(e, i) {
							this.el = t(e), this.zoomFactor = 1, this.lastScale = 1, this.offset = {
								x: 0,
								y: 0
							}, this.options = t.extend({}, this.defaults, i), this.setupMarkup(), this.bindEvents(), this.update(), this.enable()
						},
						i = function(t, e) {
							return t + e
						},
						n = function(t, e) {
							return t > e - .01 && e + .01 > t
						};
					e.prototype = {
						defaults: {
							tapZoomFactor: 2,
							zoomOutFactor: 1.3,
							animationDuration: 300,
							animationInterval: 5,
							maxZoom: 5,
							minZoom: .5,
							lockDragAxis: !1,
							use2d: !1,
							zoomStartEventName: "pz_zoomstart",
							zoomEndEventName: "pz_zoomend",
							dragStartEventName: "pz_dragstart",
							dragEndEventName: "pz_dragend",
							doubleTapEventName: "pz_doubletap"
						},
						handleDragStart: function(t) {
							this.el.trigger(this.options.dragStartEventName), this.stopAnimation(), this.lastDragPosition = !1, this.hasInteraction = !0, this.handleDrag(t)
						},
						handleDrag: function(t) {
							if(this.zoomFactor > 1) {
								var e = this.getTouches(t)[0];
								this.drag(e, this.lastDragPosition), this.offset = this.sanitizeOffset(this.offset), this.lastDragPosition = e
							}
						},
						handleDragEnd: function() {
							this.el.trigger(this.options.dragEndEventName), this.end()
						},
						handleZoomStart: function(t) {
							this.el.trigger(this.options.zoomStartEventName), this.stopAnimation(), this.lastScale = 1, this.nthZoom = 0, this.lastZoomCenter = !1, this.hasInteraction = !0
						},
						handleZoom: function(t, e) {
							var i = this.getTouchCenter(this.getTouches(t)),
								n = e / this.lastScale;
							this.lastScale = e, this.nthZoom += 1, this.nthZoom > 3 && (this.scale(n, i), this.drag(i, this.lastZoomCenter)), this.lastZoomCenter = i
						},
						handleZoomEnd: function() {
							this.el.trigger(this.options.zoomEndEventName), this.end()
						},
						handleDoubleTap: function(t) {
							var e = this.getTouches(t)[0],
								i = this.zoomFactor > 1 ? 1 : this.options.tapZoomFactor,
								n = this.zoomFactor,
								s = function(t) {
									this.scaleTo(n + t * (i - n), e)
								}.bind(this);
							this.hasInteraction || (n > i && (e = this.getCurrentZoomCenter()), this.animate(this.options.animationDuration, this.options.animationInterval, s, this.swing), this.el.trigger(this.options.doubleTapEventName))
						},
						sanitizeOffset: function(t) {
							var e = (this.zoomFactor - 1) * this.getContainerX(),
								i = (this.zoomFactor - 1) * this.getContainerY(),
								n = Math.max(e, 0),
								s = Math.max(i, 0),
								o = Math.min(e, 0),
								a = Math.min(i, 0);
							return {
								x: Math.min(Math.max(t.x, o), n),
								y: Math.min(Math.max(t.y, a), s)
							}
						},
						scaleTo: function(t, e) {
							this.scale(t / this.zoomFactor, e)
						},
						scale: function(t, e) {
							t = this.scaleZoomFactor(t), this.addOffset({
								x: (t - 1) * (e.x + this.offset.x),
								y: (t - 1) * (e.y + this.offset.y)
							})
						},
						scaleZoomFactor: function(t) {
							var e = this.zoomFactor;
							return this.zoomFactor *= t, this.zoomFactor = Math.min(this.options.maxZoom, Math.max(this.zoomFactor, this.options.minZoom)), this.zoomFactor / e
						},
						drag: function(t, e) {
							e && this.addOffset(this.options.lockDragAxis ? Math.abs(t.x - e.x) > Math.abs(t.y - e.y) ? {
								x: -(t.x - e.x),
								y: 0
							} : {
								y: -(t.y - e.y),
								x: 0
							} : {
								y: -(t.y - e.y),
								x: -(t.x - e.x)
							})
						},
						getTouchCenter: function(t) {
							return this.getVectorAvg(t)
						},
						getVectorAvg: function(t) {
							return {
								x: t.map(function(t) {
									return t.x
								}).reduce(i) / t.length,
								y: t.map(function(t) {
									return t.y
								}).reduce(i) / t.length
							}
						},
						addOffset: function(t) {
							this.offset = {
								x: this.offset.x + t.x,
								y: this.offset.y + t.y
							}
						},
						sanitize: function() {
							this.zoomFactor < this.options.zoomOutFactor ? this.zoomOutAnimation() : this.isInsaneOffset(this.offset) && this.sanitizeOffsetAnimation()
						},
						isInsaneOffset: function(t) {
							var e = this.sanitizeOffset(t);
							return e.x !== t.x || e.y !== t.y
						},
						sanitizeOffsetAnimation: function() {
							var t = this.sanitizeOffset(this.offset),
								e = {
									x: this.offset.x,
									y: this.offset.y
								},
								i = function(i) {
									this.offset.x = e.x + i * (t.x - e.x), this.offset.y = e.y + i * (t.y - e.y), this.update()
								}.bind(this);
							this.animate(this.options.animationDuration, this.options.animationInterval, i, this.swing)
						},
						zoomOutAnimation: function() {
							var t = this.zoomFactor,
								e = 1,
								i = this.getCurrentZoomCenter(),
								n = function(n) {
									this.scaleTo(t + n * (e - t), i)
								}.bind(this);
							this.animate(this.options.animationDuration, this.options.animationInterval, n, this.swing)
						},
						updateAspectRatio: function() {
							this.setContainerY()
						},
						getInitialZoomFactor: function() {
							return this.container[0].offsetWidth / this.el[0].offsetWidth
						},
						getAspectRatio: function() {
							return this.el[0].offsetWidth / this.el[0].offsetHeight
						},
						getCurrentZoomCenter: function() {
							var t = this.container[0].offsetWidth * this.zoomFactor,
								e = this.offset.x,
								i = t - e - this.container[0].offsetWidth,
								n = e / i,
								s = n * this.container[0].offsetWidth / (n + 1),
								o = this.container[0].offsetHeight * this.zoomFactor,
								a = this.offset.y,
								r = o - a - this.container[0].offsetHeight,
								l = a / r,
								c = l * this.container[0].offsetHeight / (l + 1);
							return 0 === i && (s = this.container[0].offsetWidth), 0 === r && (c = this.container[0].offsetHeight), {
								x: s,
								y: c
							}
						},
						canDrag: function() {
							return !n(this.zoomFactor, 1)
						},
						getTouches: function(t) {
							var e = this.container.offset();
							return Array.prototype.slice.call(t.touches).map(function(t) {
								return {
									x: t.pageX - e.left,
									y: t.pageY - e.top
								}
							})
						},
						animate: function(t, e, i, n, s) {
							var o = (new Date).getTime(),
								a = function() {
									if(this.inAnimation) {
										var r = (new Date).getTime() - o,
											l = r / t;
										r >= t ? (i(1), s && s(), this.update(), this.stopAnimation(), this.update()) : (n && (l = n(l)), i(l), this.update(), setTimeout(a, e))
									}
								}.bind(this);
							this.inAnimation = !0, a()
						},
						stopAnimation: function() {
							this.inAnimation = !1
						},
						swing: function(t) {
							return -Math.cos(t * Math.PI) / 2 + .5
						},
						getContainerX: function() {
							return window.innerWidth
						},
						getContainerY: function() {
							return window.innerHeight
						},
						setContainerY: function(t) {
							var e = window.innerHeight;
							return this.el.css({
								height: e
							}), this.container.height(e)
						},
						setupMarkup: function() {
							this.container = t('<div class="pinch-zoom-container"></div>'), this.el.before(this.container), this.container.append(this.el), this.container.css({
								overflow: "hidden",
								position: "relative"
							}), this.el.css({
								"-webkit-transform-origin": "0% 0%",
								"-moz-transform-origin": "0% 0%",
								"-ms-transform-origin": "0% 0%",
								"-o-transform-origin": "0% 0%",
								"transform-origin": "0% 0%",
								position: "absolute"
							})
						},
						end: function() {
							this.hasInteraction = !1, this.sanitize(), this.update()
						},
						bindEvents: function() {
							s(this.container.get(0), this), t(window).on("resize", this.update.bind(this)), t(this.el).find("img").on("load", this.update.bind(this))
						},
						update: function() {
							this.updatePlaned || (this.updatePlaned = !0, setTimeout(function() {
								this.updatePlaned = !1, this.updateAspectRatio();
								var t = this.getInitialZoomFactor() * this.zoomFactor,
									e = -this.offset.x / t,
									i = -this.offset.y / t,
									n = "scale3d(" + t + ", " + t + ",1) translate3d(" + e + "px," + i + "px,0px)",
									s = "scale(" + t + ", " + t + ") translate(" + e + "px," + i + "px)",
									o = function() {
										this.clone && (this.clone.remove(), delete this.clone)
									}.bind(this);
								!this.options.use2d || this.hasInteraction || this.inAnimation ? (this.is3d = !0, o(), this.el.css({
									"-webkit-transform": n,
									"-o-transform": s,
									"-ms-transform": s,
									"-moz-transform": s,
									transform: n
								})) : (this.is3d && (this.clone = this.el.clone(), this.clone.css("pointer-events", "none"), this.clone.appendTo(this.container), setTimeout(o, 200)), this.el.css({
									"-webkit-transform": s,
									"-o-transform": s,
									"-ms-transform": s,
									"-moz-transform": s,
									transform: s
								}), this.is3d = !1)
							}.bind(this), 0))
						},
						enable: function() {
							this.enabled = !0
						},
						disable: function() {
							this.enabled = !1
						}
					};
					var s = function(t, e) {
						var i = null,
							n = 0,
							s = null,
							o = null,
							a = function(t, n) {
								if(i !== t) {
									if(i && !t) switch(i) {
										case "zoom":
											e.handleZoomEnd(n);
											break;
										case "drag":
											e.handleDragEnd(n)
									}
									switch(t) {
										case "zoom":
											e.handleZoomStart(n);
											break;
										case "drag":
											e.handleDragStart(n)
									}
								}
								i = t
							},
							r = function(t) {
								2 === n ? a("zoom") : 1 === n && e.canDrag() ? a("drag", t) : a(null, t)
							},
							l = function(t) {
								return Array.prototype.slice.call(t).map(function(t) {
									return {
										x: t.pageX,
										y: t.pageY
									}
								})
							},
							c = function(t, e) {
								var i, n;
								return i = t.x - e.x, n = t.y - e.y, Math.sqrt(i * i + n * n)
							},
							u = function(t, e) {
								var i = c(t[0], t[1]),
									n = c(e[0], e[1]);
								return n / i
							},
							h = function(t) {
								t.stopPropagation(), t.preventDefault()
							},
							d = function(t) {
								var o = (new Date).getTime();
								if(n > 1 && (s = null), 300 > o - s) switch(h(t), e.handleDoubleTap(t), i) {
									case "zoom":
										e.handleZoomEnd(t);
										break;
									case "drag":
										e.handleDragEnd(t)
								}
								1 === n && (s = o)
							},
							p = !0;
						t.addEventListener("touchstart", function(t) {
							e.enabled && (p = !0, n = t.touches.length, d(t))
						}), t.addEventListener("touchmove", function(t) {
							if(e.enabled) {
								if(p) r(t), i && h(t), o = l(t.touches);
								else {
									switch(i) {
										case "zoom":
											e.handleZoom(t, u(o, l(t.touches)));
											break;
										case "drag":
											e.handleDrag(t)
									}
									i && (h(t), e.update())
								}
								p = !1
							}
						}), t.addEventListener("touchend", function(t) {
							e.enabled && (n = t.touches.length, r(t))
						})
					};
					return e
				};
			e.exports = s.pichzoom = o(n)
		}, {
			2: 2
		}],
		15: [function(t, e, i) {
			"use strict";
			var n = window.jQuery,
				s = t(2),
				o = n(window),
				a = function(t, e) {
					this.options = n.extend({}, a.DEFAULTS, e), this.$element = n(t), this.active = null, this.$popover = this.options.target && n(this.options.target) || null, this.init(), this._bindEvents()
				};
			a.DEFAULTS = {
				theme: void 0,
				trigger: "click",
				content: "",
				open: !1,
				target: void 0,
				tpl: '<div class="am-popover"><div class="am-popover-inner"></div><div class="am-popover-caret"></div></div>'
			}, a.prototype.init = function() {
				function t() {
					i.sizePopover()
				}
				var e, i = this,
					o = this.$element;
				this.options.target || (this.$popover = this.getPopover(), this.setContent()), e = this.$popover, e.appendTo(n("body")), this.sizePopover(), o.on("open.popover.amui", function() {
					n(window).on("resize.popover.amui", s.utils.debounce(t, 50))
				}), o.on("close.popover.amui", function() {
					n(window).off("resize.popover.amui", t)
				}), this.options.open && this.open()
			}, a.prototype.sizePopover = function() {
				var t = this.$element,
					e = this.$popover;
				if(e && e.length) {
					var i = e.outerWidth(),
						n = e.outerHeight(),
						s = e.find(".am-popover-caret"),
						a = s.outerWidth() / 2 || 8,
						r = n + 8,
						l = t.outerWidth(),
						c = t.outerHeight(),
						u = t.offset(),
						h = t[0].getBoundingClientRect(),
						d = o.height(),
						p = o.width(),
						m = 0,
						f = 0,
						v = 0,
						g = 2,
						w = "top";
					e.css({
						left: "",
						top: ""
					}).removeClass("am-popover-left am-popover-right am-popover-top am-popover-bottom"), r - g < h.top + g ? m = u.top - r - g : r < d - h.top - h.height ? (w = "bottom", m = u.top + c + a + g) : (w = "middle", m = c / 2 + u.top - n / 2), "top" === w || "bottom" === w ? (f = l / 2 + u.left - i / 2, v = f, 5 > f && (f = 5), f + i > p && (f = p - i - 20), "top" === w && e.addClass("am-popover-top"), "bottom" === w && e.addClass("am-popover-bottom"), v -= f) : "middle" === w && (f = u.left - i - a, e.addClass("am-popover-left"), 5 > f && (f = u.left + l + a, e.removeClass("am-popover-left").addClass("am-popover-right")), f + i > p && (f = p - i - 5, e.removeClass("am-popover-left").addClass("am-popover-right"))), e.css({
						top: m + "px",
						left: f + "px"
					})
				}
			}, a.prototype.toggle = function() {
				return this[this.active ? "close" : "open"]()
			}, a.prototype.open = function() {
				var t = this.$popover;
				this.$element.trigger("open.popover.amui"), this.sizePopover(), t.show().addClass("am-active"), this.active = !0
			}, a.prototype.close = function() {
				var t = this.$popover;
				this.$element.trigger("close.popover.amui"), t.removeClass("am-active").trigger("closed.popover.amui").hide(), this.active = !1
			}, a.prototype.getPopover = function() {
				var t = s.utils.generateGUID("am-popover"),
					e = [];
				return this.options.theme && n.each(this.options.theme.split(","), function(t, i) {
					e.push("am-popover-" + n.trim(i))
				}), n(this.options.tpl).attr("id", t).addClass(e.join(" "))
			}, a.prototype.setContent = function(t) {
				t = t || this.options.content, this.$popover && this.$popover.find(".am-popover-inner").empty().html(t)
			}, a.prototype._bindEvents = function() {
				for(var t = "popover.amui", e = this.options.trigger.split(" "), i = e.length; i--;) {
					var s = e[i];
					if("click" === s) this.$element.on("click." + t, n.proxy(this.toggle, this));
					else {
						var o = "hover" == s ? "mouseenter" : "focusin",
							a = "hover" == s ? "mouseleave" : "focusout";
						this.$element.on(o + "." + t, n.proxy(this.open, this)), this.$element.on(a + "." + t, n.proxy(this.close, this))
					}
				}
			}, s.plugin("popover", a), s.ready(function(t) {
				n("[data-am-popover]", t).popover()
			}), e.exports = a
		}, {
			2: 2
		}],
		16: [function(t, e, i) {
			"use strict";
			var n = (window.jQuery, t(2)),
				s = function() {
					function t(t, e, i) {
						return e > t ? e : t > i ? i : t
					}

					function e(t) {
						return 100 * (-1 + t)
					}

					function i(t, i, n) {
						var s;
						return s = "translate3d" === c.positionUsing ? {
							transform: "translate3d(" + e(t) + "%,0,0)"
						} : "translate" === c.positionUsing ? {
							transform: "translate(" + e(t) + "%,0)"
						} : {
							"margin-left": e(t) + "%"
						}, s.transition = "all " + i + "ms " + n, s
					}

					function n(t, e) {
						var i = "string" == typeof t ? t : a(t);
						return i.indexOf(" " + e + " ") >= 0
					}

					function s(t, e) {
						var i = a(t),
							s = i + e;
						n(i, e) || (t.className = s.substring(1))
					}

					function o(t, e) {
						var i, s = a(t);
						n(t, e) && (i = s.replace(" " + e + " ", " "), t.className = i.substring(1, i.length - 1))
					}

					function a(t) {
						return(" " + (t.className || "") + " ").replace(/\s+/gi, " ")
					}

					function r(t) {
						t && t.parentNode && t.parentNode.removeChild(t)
					}
					var l = {};
					l.version = "0.2.0";
					var c = l.settings = {
						minimum: .08,
						easing: "ease",
						positionUsing: "",
						speed: 200,
						trickle: !0,
						trickleRate: .02,
						trickleSpeed: 800,
						showSpinner: !0,
						parent: "body",
						barSelector: '[role="nprogress-bar"]',
						spinnerSelector: '[role="nprogress-spinner"]',
						template: '<div class="nprogress-bar" role="nprogress-bar"><div class="nprogress-peg"></div></div><div class="nprogress-spinner" role="nprogress-spinner"><div class="nprogress-spinner-icon"></div></div>'
					};
					l.configure = function(t) {
							var e, i;
							for(e in t) i = t[e], void 0 !== i && t.hasOwnProperty(e) && (c[e] = i);
							return this
						}, l.status = null, l.set = function(e) {
							var n = l.isStarted();
							e = t(e, c.minimum, 1), l.status = 1 === e ? null : e;
							var s = l.render(!n),
								o = s.querySelector(c.barSelector),
								a = c.speed,
								r = c.easing;
							return s.offsetWidth, u(function(t) {
								"" === c.positionUsing && (c.positionUsing = l.getPositioningCSS()), h(o, i(e, a, r)), 1 === e ? (h(s, {
									transition: "none",
									opacity: 1
								}), s.offsetWidth, setTimeout(function() {
									h(s, {
										transition: "all " + a + "ms linear",
										opacity: 0
									}), setTimeout(function() {
										l.remove(), t()
									}, a)
								}, a)) : setTimeout(t, a)
							}), this
						}, l.isStarted = function() {
							return "number" == typeof l.status
						}, l.start = function() {
							l.status || l.set(0);
							var t = function() {
								setTimeout(function() {
									l.status && (l.trickle(), t())
								}, c.trickleSpeed)
							};
							return c.trickle && t(), this
						}, l.done = function(t) {
							return t || l.status ? l.inc(.3 + .5 * Math.random()).set(1) : this
						}, l.inc = function(e) {
							var i = l.status;
							return i ? ("number" != typeof e && (e = (1 - i) * t(Math.random() * i, .1, .95)), i = t(i + e, 0, .994), l.set(i)) : l.start()
						}, l.trickle = function() {
							return l.inc(Math.random() * c.trickleRate)
						},
						function() {
							var t = 0,
								e = 0;
							l.promise = function(i) {
								return i && "resolved" !== i.state() ? (0 === e && l.start(), t++, e++, i.always(function() {
									e--, 0 === e ? (t = 0, l.done()) : l.set((t - e) / t)
								}), this) : this
							}
						}(), l.render = function(t) {
							if(l.isRendered()) return document.getElementById("nprogress");
							s(document.documentElement, "nprogress-busy");
							var i = document.createElement("div");
							i.id = "nprogress", i.innerHTML = c.template;
							var n, o = i.querySelector(c.barSelector),
								a = t ? "-100" : e(l.status || 0),
								u = document.querySelector(c.parent);
							return h(o, {
								transition: "all 0 linear",
								transform: "translate3d(" + a + "%,0,0)"
							}), c.showSpinner || (n = i.querySelector(c.spinnerSelector), n && r(n)), u != document.body && s(u, "nprogress-custom-parent"), u.appendChild(i), i
						}, l.remove = function() {
							o(document.documentElement, "nprogress-busy"), o(document.querySelector(c.parent), "nprogress-custom-parent");
							var t = document.getElementById("nprogress");
							t && r(t)
						}, l.isRendered = function() {
							return !!document.getElementById("nprogress")
						}, l.getPositioningCSS = function() {
							var t = document.body.style,
								e = "WebkitTransform" in t ? "Webkit" : "MozTransform" in t ? "Moz" : "msTransform" in t ? "ms" : "OTransform" in t ? "O" : "";
							return e + "Perspective" in t ? "translate3d" : e + "Transform" in t ? "translate" : "margin"
						};
					var u = function() {
							function t() {
								var i = e.shift();
								i && i(t)
							}
							var e = [];
							return function(i) {
								e.push(i), 1 == e.length && t()
							}
						}(),
						h = function() {
							function t(t) {
								return t.replace(/^-ms-/, "ms-").replace(/-([\da-z])/gi, function(t, e) {
									return e.toUpperCase()
								})
							}

							function e(t) {
								var e = document.body.style;
								if(t in e) return t;
								for(var i, n = s.length, o = t.charAt(0).toUpperCase() + t.slice(1); n--;)
									if(i = s[n] + o, i in e) return i;
								return t
							}

							function i(i) {
								return i = t(i), o[i] || (o[i] = e(i))
							}

							function n(t, e, n) {
								e = i(e), t.style[e] = n
							}
							var s = ["Webkit", "O", "Moz", "ms"],
								o = {};
							return function(t, e) {
								var i, s, o = arguments;
								if(2 == o.length)
									for(i in e) s = e[i], void 0 !== s && e.hasOwnProperty(i) && n(t, i, s);
								else n(t, o[1], o[2])
							}
						}();
					return l
				}();
			e.exports = n.progress = s
		}, {
			2: 2
		}],
		17: [function(t, e, i) {
			"use strict";
			var n = window.jQuery,
				s = t(2),
				o = t(14),
				a = t(30),
				r = s.support.animation,
				l = s.support.transition,
				c = function(t, e) {
					this.$element = n(t), this.$body = n(document.body), this.options = n.extend({}, c.DEFAULTS, e), this.$pureview = n(this.options.tpl).attr("id", s.utils.generateGUID("am-pureview")), this.$slides = null, this.transitioning = null, this.scrollbarWidth = 0, this.init()
				};
			c.DEFAULTS = {
				tpl: '<div class="am-pureview am-pureview-bar-active"><ul class="am-pureview-slider"></ul><ul class="am-pureview-direction"><li class="am-pureview-prev"><a href=""></a></li><li class="am-pureview-next"><a href=""></a></li></ul><ol class="am-pureview-nav"></ol><div class="am-pureview-bar am-active"><span class="am-pureview-title"></span><div class="am-pureview-counter"><span class="am-pureview-current"></span> / <span class="am-pureview-total"></span></div></div><div class="am-pureview-actions am-active"><a href="javascript: void(0)" class="am-icon-chevron-left" data-am-close="pureview"></a></div></div>',
				className: {
					prevSlide: "am-pureview-slide-prev",
					nextSlide: "am-pureview-slide-next",
					onlyOne: "am-pureview-only",
					active: "am-active",
					barActive: "am-pureview-bar-active",
					activeBody: "am-pureview-active"
				},
				selector: {
					slider: ".am-pureview-slider",
					close: '[data-am-close="pureview"]',
					total: ".am-pureview-total",
					current: ".am-pureview-current",
					title: ".am-pureview-title",
					actions: ".am-pureview-actions",
					bar: ".am-pureview-bar",
					pinchZoom: ".am-pinch-zoom",
					nav: ".am-pureview-nav"
				},
				shareBtn: !1,
				toggleToolbar: !0,
				target: "img",
				weChatImagePreview: !0
			}, c.prototype.init = function() {
				var t = this,
					e = this.options,
					i = this.$element,
					s = this.$pureview;
				this.refreshSlides(), n("body").append(s), this.$title = s.find(e.selector.title), this.$current = s.find(e.selector.current), this.$bar = s.find(e.selector.bar), this.$actions = s.find(e.selector.actions), e.shareBtn && this.$actions.append('<a href="javascript: void(0)" class="am-icon-share-square-o" data-am-toggle="share"></a>'), this.$element.on("click.pureview.amui", e.target, function(i) {
					i.preventDefault();
					var n = t.$images.index(this);
					e.weChatImagePreview && window.WeixinJSBridge ? window.WeixinJSBridge.invoke("imagePreview", {
						current: t.imgUrls[n],
						urls: t.imgUrls
					}) : t.open(n)
				}), s.find(".am-pureview-direction").on("click.direction.pureview.amui", "li", function(e) {
					e.preventDefault(), n(this).is(".am-pureview-prev") ? t.prevSlide() : t.nextSlide()
				}), s.find(e.selector.nav).on("click.nav.pureview.amui", "li", function() {
					var e = t.$navItems.index(n(this));
					t.activate(t.$slides.eq(e))
				}), s.find(e.selector.close).on("click.close.pureview.amui", function(e) {
					e.preventDefault(), t.close()
				}), this.$slider.hammer().on("swipeleft.pureview.amui", function(e) {
					e.preventDefault(), t.nextSlide()
				}).on("swiperight.pureview.amui", function(e) {
					e.preventDefault(), t.prevSlide()
				}).on("press.pureview.amui", function(i) {
					i.preventDefault(), e.toggleToolbar && t.toggleToolBar()
				}), this.$slider.data("hammer").get("swipe").set({
					direction: a.DIRECTION_HORIZONTAL,
					velocity: .35
				}), i.DOMObserve({
					childList: !0,
					subtree: !0
				}, function(t, e) {}), i.on("changed.dom.amui", function(e) {
					e.stopPropagation(), t.refreshSlides()
				}), n(document).on("keydown.pureview.amui", n.proxy(function(t) {
					var e = t.keyCode;
					37 == e ? this.prevSlide() : 39 == e ? this.nextSlide() : 27 == e && this.close()
				}, this))
			}, c.prototype.refreshSlides = function() {
				this.$images = this.$element.find(this.options.target);
				var t = this,
					e = this.options,
					i = this.$pureview,
					s = n([]),
					o = n([]),
					a = this.$images,
					r = a.length;
				this.$slider = i.find(e.selector.slider), this.$nav = i.find(e.selector.nav);
				var l = "data-am-pureviewed";
				this.imgUrls = this.imgUrls || [], r && (1 === r && i.addClass(e.className.onlyOne), a.not("[" + l + "]").each(function(e, i) {
					var a, r;
					"A" === i.nodeName ? (a = i.href, r = i.title || "") : (a = n(i).data("rel") || i.src, r = n(i).attr("alt") || ""), i.setAttribute(l, "1"), t.imgUrls.push(a), s = s.add(n('<li data-src="' + a + '" data-title="' + r + '"></li>')), o = o.add(n("<li>" + (e + 1) + "</li>"))
				}), i.find(e.selector.total).text(r), this.$slider.append(s), this.$nav.append(o), this.$navItems = this.$nav.find("li"), this.$slides = this.$slider.find("li"))
			}, c.prototype.loadImage = function(t, e) {
				var i = "image-appended";
				if(!t.data(i)) {
					var s = n("<img>", {
						src: t.data("src"),
						alt: t.data("title")
					});
					t.html(s).wrapInner('<div class="am-pinch-zoom"></div>').redraw();
					var a = t.find(this.options.selector.pinchZoom);
					a.data("amui.pinchzoom", new o(a[0], {})), t.data("image-appended", !0)
				}
				e && e.call(this)
			}, c.prototype.activate = function(t) {
				var e = this.options,
					i = this.$slides,
					o = i.index(t),
					a = t.data("title") || "",
					r = e.className.active;
				i.find("." + r).is(t) || this.transitioning || (this.loadImage(t, function() {
					s.utils.imageLoader(t.find("img"), function(e) {
						t.find(".am-pinch-zoom").addClass("am-pureview-loaded"), n(e).addClass("am-img-loaded")
					})
				}), this.transitioning = 1, this.$title.text(a), this.$current.text(o + 1), i.removeClass(), t.addClass(r), i.eq(o - 1).addClass(e.className.prevSlide), i.eq(o + 1).addClass(e.className.nextSlide), this.$navItems.removeClass().eq(o).addClass(e.className.active), l ? t.one(l.end, n.proxy(function() {
					this.transitioning = 0
				}, this)).emulateTransitionEnd(300) : this.transitioning = 0)
			}, c.prototype.nextSlide = function() {
				if(1 !== this.$slides.length) {
					var t = this.$slides,
						e = t.filter(".am-active"),
						i = t.index(e),
						n = "am-animation-right-spring";
					i + 1 >= t.length ? r && e.addClass(n).on(r.end, function() {
						e.removeClass(n)
					}) : this.activate(t.eq(i + 1))
				}
			}, c.prototype.prevSlide = function() {
				if(1 !== this.$slides.length) {
					var t = this.$slides,
						e = t.filter(".am-active"),
						i = this.$slides.index(e),
						n = "am-animation-left-spring";
					0 === i ? r && e.addClass(n).on(r.end, function() {
						e.removeClass(n)
					}) : this.activate(t.eq(i - 1))
				}
			}, c.prototype.toggleToolBar = function() {
				this.$pureview.toggleClass(this.options.className.barActive)
			}, c.prototype.open = function(t) {
				var e = t || 0;
				this.checkScrollbar(), this.setScrollbar(), this.activate(this.$slides.eq(e)), this.$pureview.show().redraw().addClass(this.options.className.active), this.$body.addClass(this.options.className.activeBody)
			}, c.prototype.close = function() {
				function t() {
					this.$pureview.hide(), this.$body.removeClass(e.className.activeBody), this.resetScrollbar()
				}
				var e = this.options;
				this.$pureview.removeClass(e.className.active), this.$slides.removeClass(), l ? this.$pureview.one(l.end, n.proxy(t, this)).emulateTransitionEnd(300) : t.call(this)
			}, c.prototype.checkScrollbar = function() {
				this.scrollbarWidth = s.utils.measureScrollbar()
			}, c.prototype.setScrollbar = function() {
				var t = parseInt(this.$body.css("padding-right") || 0, 10);
				this.scrollbarWidth && this.$body.css("padding-right", t + this.scrollbarWidth)
			}, c.prototype.resetScrollbar = function() {
				this.$body.css("padding-right", "")
			}, s.plugin("pureview", c), s.ready(function(t) {
				n("[data-am-pureview]", t).pureview()
			}), e.exports = c
		}, {
			14: 14,
			2: 2,
			30: 30
		}],
		18: [function(t, e, i) {
			"use strict";
			var n = window.jQuery,
				s = t(2),
				o = function(t, e) {
					if(s.support.animation) {
						this.options = n.extend({}, o.DEFAULTS, e), this.$element = n(t);
						var i = function() {
							s.utils.rAF.call(window, n.proxy(this.checkView, this))
						}.bind(this);
						this.$window = n(window).on("scroll.scrollspy.amui", i).on("resize.scrollspy.amui orientationchange.scrollspy.amui", s.utils.debounce(i, 50)), this.timer = this.inViewState = this.initInView = null, i()
					}
				};
			o.DEFAULTS = {
				animation: "fade",
				className: {
					inView: "am-scrollspy-inview",
					init: "am-scrollspy-init"
				},
				repeat: !0,
				delay: 0,
				topOffset: 0,
				leftOffset: 0
			}, o.prototype.checkView = function() {
				var t = this.$element,
					e = this.options,
					i = s.utils.isInView(t, e),
					n = e.animation ? " am-animation-" + e.animation : "";
				i && !this.inViewState && (this.timer && clearTimeout(this.timer), this.initInView || (t.addClass(e.className.init), this.offset = t.offset(), this.initInView = !0, t.trigger("init.scrollspy.amui")), this.timer = setTimeout(function() {
					i && t.addClass(e.className.inView + n).width()
				}, e.delay), this.inViewState = !0, t.trigger("inview.scrollspy.amui")), !i && this.inViewState && e.repeat && (t.removeClass(e.className.inView + n), this.inViewState = !1, t.trigger("outview.scrollspy.amui"))
			}, o.prototype.check = function() {
				s.utils.rAF.call(window, n.proxy(this.checkView, this))
			}, s.plugin("scrollspy", o), s.ready(function(t) {
				n("[data-am-scrollspy]", t).scrollspy()
			}), e.exports = o
		}, {
			2: 2
		}],
		19: [function(t, e, i) {
			"use strict";
			var n = window.jQuery,
				s = t(2);
			t(22);
			var o = function(t, e) {
				this.options = n.extend({}, o.DEFAULTS, e), this.$element = n(t), this.anchors = [], this.$links = this.$element.find('a[href^="#"]').each(function(t, e) {
					this.anchors.push(n(e).attr("href"))
				}.bind(this)), this.$targets = n(this.anchors.join(", "));
				var i = function() {
					s.utils.rAF.call(window, n.proxy(this.process, this))
				}.bind(this);
				this.$window = n(window).on("scroll.scrollspynav.amui", i).on("resize.scrollspynav.amui orientationchange.scrollspynav.amui", s.utils.debounce(i, 50)), i(), this.scrollProcess()
			};
			o.DEFAULTS = {
				className: {
					active: "am-active"
				},
				closest: !1,
				smooth: !0,
				offsetTop: 0
			}, o.prototype.process = function() {
				var t = this.$window.scrollTop(),
					e = this.options,
					i = [],
					o = this.$links,
					a = this.$targets;
				if(a.each(function(t, n) {
						s.utils.isInView(n, e) && i.push(n)
					}), i.length) {
					var r;
					if(n.each(i, function(e, i) {
							return n(i).offset().top >= t ? (r = n(i), !1) : void 0
						}), !r) return;
					e.closest ? (o.closest(e.closest).removeClass(e.className.active), o.filter('a[href="#' + r.attr("id") + '"]').closest(e.closest).addClass(e.className.active)) : o.removeClass(e.className.active).filter('a[href="#' + r.attr("id") + '"]').addClass(e.className.active)
				}
			}, o.prototype.scrollProcess = function() {
				var t = this.$links,
					e = this.options;
				e.smooth && n.fn.smoothScroll && t.on("click", function(t) {
					t.preventDefault();
					var i = n(this),
						s = n(i.attr("href"));
					if(s) {
						var o = e.offsetTop && !isNaN(parseInt(e.offsetTop)) && parseInt(e.offsetTop) || 0;
						n(window).smoothScroll({
							position: s.offset().top - o
						})
					}
				})
			}, s.plugin("scrollspynav", o), s.ready(function(t) {
				n("[data-am-scrollspy-nav]", t).scrollspynav()
			}), e.exports = o
		}, {
			2: 2,
			22: 22
		}],
		20: [function(t, e, i) {
			"use strict";
			var n = window.jQuery,
				s = t(2);
			n.expr[":"].containsNC = function(t, e, i, n) {
				return(t.textContent || t.innerText || "").toLowerCase().indexOf((i[3] || "").toLowerCase()) >= 0
			};
			var o = function(t, e) {
				this.$element = n(t), this.options = n.extend({}, o.DEFAULTS, e), this.$originalOptions = this.$element.find("option"), this.multiple = t.multiple, this.$selector = null, this.initialized = !1, this.init()
			};
			o.DEFAULTS = {
				btnWidth: null,
				btnSize: null,
				btnStyle: "default",
				dropUp: 0,
				maxHeight: null,
				placeholder: "\u70b9\u51fb\u9009\u62e9...",
				selectedClass: "am-checked",
				disabledClass: "am-disabled",
				searchBox: !1,
				tpl: '<div class="am-selected am-dropdown <%= dropUp ? \'am-dropdown-up\': \'\' %>" id="<%= id %>" data-am-dropdown>  <button type="button" class="am-selected-btn am-btn am-dropdown-toggle">    <span class="am-selected-status am-fl"></span>    <i class="am-selected-icon am-icon-caret-<%= dropUp ? \'up\' : \'down\' %>"></i>  </button>  <div class="am-selected-content am-dropdown-content">    <h2 class="am-selected-header"><span class="am-icon-chevron-left">\u8fd4\u56de</span></h2>   <% if (searchBox) { %>   <div class="am-selected-search">     <input autocomplete="off" class="am-form-field am-input-sm" />   </div>   <% } %>    <ul class="am-selected-list">      <% for (var i = 0; i < options.length; i++) { %>       <% var option = options[i] %>       <% if (option.header) { %>  <li data-group="<%= option.group %>" class="am-selected-list-header">       <%= option.text %></li>       <% } else { %>       <li class="<%= option.classNames%>"          data-index="<%= option.index %>"          data-group="<%= option.group || 0 %>"          data-value="<%= option.value %>" >         <span class="am-selected-text"><%= option.text %></span>         <i class="am-icon-check"></i></li>      <% } %>      <% } %>    </ul>    <div class="am-selected-hint"></div>  </div></div>',
				listTpl: '<% for (var i = 0; i < options.length; i++) { %>       <% var option = options[i] %>       <% if (option.header) { %>  <li data-group="<%= option.group %>" class="am-selected-list-header">       <%= option.text %></li>       <% } else { %>       <li class="<%= option.classNames %>"          data-index="<%= option.index %>"          data-group="<%= option.group || 0 %>"          data-value="<%= option.value %>" >         <span class="am-selected-text"><%= option.text %></span>         <i class="am-icon-check"></i></li>      <% } %>      <% } %>'
			}, o.prototype.init = function() {
				var t = this,
					e = this.$element,
					i = this.options;
				e.hide();
				var o = {
					id: s.utils.generateGUID("am-selected"),
					multiple: this.multiple,
					options: [],
					searchBox: i.searchBox,
					dropUp: i.dropUp,
					placeholder: i.placeholder
				};
				this.$selector = n(s.template(this.options.tpl, o)), this.$selector.css({
					width: this.options.btnWidth
				}), this.$list = this.$selector.find(".am-selected-list"), this.$searchField = this.$selector.find(".am-selected-search input"), this.$hint = this.$selector.find(".am-selected-hint");
				var a = this.$selector.find(".am-selected-btn"),
					r = [];
				i.btnSize && r.push("am-btn-" + i.btnSize), i.btnStyle && r.push("am-btn-" + i.btnStyle), a.addClass(r.join(" ")), this.$selector.dropdown({
					justify: a
				}), i.maxHeight && this.$selector.find(".am-selected-list").css({
					"max-height": i.maxHeight,
					"overflow-y": "scroll"
				});
				var l = [],
					c = e.attr("minchecked"),
					u = e.attr("maxchecked");
				e[0].required && l.push("\u5fc5\u9009"), (c || u) && (c && l.push("\u81f3\u5c11\u9009\u62e9 " + c + " \u9879"), u && l.push("\u81f3\u591a\u9009\u62e9 " + u + " \u9879")), this.$hint.text(l.join("\uff0c")), this.renderOptions(), this.$element.after(this.$selector), this.dropdown = this.$selector.data("amui.dropdown"), this.$status = this.$selector.find(".am-selected-status"), setTimeout(function() {
					t.syncData(), t.initialized = !0
				}, 0), this.bindEvents()
			}, o.prototype.renderOptions = function() {
				function t(t, e, s) {
					var o = "";
					e.disabled && (o += i.disabledClass), !e.disabled && e.selected && (o += i.selectedClass), n.push({
						group: s,
						index: t,
						classNames: o,
						text: e.text,
						value: e.value
					})
				}
				var e = this.$element,
					i = this.options,
					n = [],
					o = e.find("optgroup");
				this.$originalOptions = this.$element.find("option"), this.multiple || null !== e.val() || this.$originalOptions.length && (this.$originalOptions.get(0).selected = !0), o.length ? o.each(function(e) {
					n.push({
						header: !0,
						group: e + 1,
						text: this.label
					}), o.eq(e).find("option").each(function(i, n) {
						t(i, n, e)
					})
				}) : this.$originalOptions.each(function(e, i) {
					t(e, i, null)
				}), this.$list.html(s.template(i.listTpl, {
					options: n
				})), this.$shadowOptions = this.$list.find("> li").not(".am-selected-list-header")
			}, o.prototype.setChecked = function(t) {
				var e = this.options,
					i = n(t),
					s = i.hasClass(e.selectedClass);
				if(!this.multiple) {
					if(s) return;
					this.dropdown.close(), this.$shadowOptions.not(i).removeClass(e.selectedClass)
				}
				i.toggleClass(e.selectedClass), this.syncData(t)
			}, o.prototype.syncData = function(t) {
				var e = this,
					i = this.options,
					s = [],
					o = n([]);
				if(this.$shadowOptions.filter("." + i.selectedClass).each(function() {
						var i = n(this);
						s.push(i.find(".am-selected-text").text()), t || (o = o.add(e.$originalOptions.filter('[value="' + i.data("value") + '"]').prop("selected", !0)))
					}), t) {
					var a = n(t);
					this.$originalOptions.filter('[value="' + a.data("value") + '"]').prop("selected", a.hasClass(i.selectedClass))
				} else this.$originalOptions.not(o).prop("selected", !1);
				this.$element.val() || (s = [i.placeholder]), this.$status.text(s.join(", ")), this.initialized && this.$element.trigger("change")
			}, o.prototype.bindEvents = function() {
				var t = this,
					e = "am-selected-list-header",
					i = s.utils.debounce(function(i) {
						t.$shadowOptions.not("." + e).hide().filter(':containsNC("' + i.target.value + '")').show()
					}, 100);
				this.$list.on("click", "> li", function(i) {
					var s = n(this);
					!s.hasClass(t.options.disabledClass) && !s.hasClass(e) && t.setChecked(this)
				}), this.$searchField.on("keyup.selected.amui", i), this.$selector.on("closed.dropdown.amui", function() {
					t.$searchField.val(""), t.$shadowOptions.css({
						display: ""
					})
				}), s.support.mutationobserver && (this.observer = new s.support.mutationobserver(function() {
					t.$element.trigger("changed.selected.amui")
				}), this.observer.observe(this.$element[0], {
					childList: !0,
					attributes: !0,
					subtree: !0,
					characterData: !0
				})), this.$element.on("changed.selected.amui", function() {
					t.renderOptions(), t.syncData()
				})
			}, o.prototype.destroy = function() {
				this.$element.removeData("amui.selected").show(), this.$selector.remove()
			}, s.plugin("selected", o), s.ready(function(t) {
				n("[data-am-selected]", t).selected()
			}), e.exports = o
		}, {
			2: 2
		}],
		21: [function(t, e, i) {
			"use strict";
			t(12);
			var n = window.jQuery,
				s = t(2),
				o = t(31),
				a = document,
				r = n(a),
				l = function(t) {
					this.options = n.extend({}, l.DEFAULTS, t || {}), this.$element = null, this.$wechatQr = null, this.pics = null, this.inited = !1, this.active = !1
				};
			l.DEFAULTS = {
				sns: ["weibo", "qq", "qzone", "tqq", "wechat", "renren"],
				title: "\u5206\u4eab\u5230",
				cancel: "\u53d6\u6d88",
				closeOnShare: !0,
				id: s.utils.generateGUID("am-share"),
				desc: "Hi\uff0c\u5b64\u591c\u89c2\u5929\u8c61\uff0c\u53d1\u73b0\u4e00\u4e2a\u4e0d\u9519\u7684\u897f\u897f\uff0c\u5206\u4eab\u4e00\u4e0b\u4e0b ;-)",
				via: "Amaze UI",
				tpl: '<div class="am-share am-modal-actions" id="<%= id %>"><h3 class="am-share-title"><%= title %></h3><ul class="am-share-sns am-avg-sm-3"><% for(var i = 0; i < sns.length; i++) {%><li><a href="<%= sns[i].shareUrl %>" data-am-share-to="<%= sns[i].id %>" ><i class="am-icon-<%= sns[i].icon %>"></i><span><%= sns[i].title %></span></a></li><% } %></ul><div class="am-share-footer"><button class="am-btn am-btn-default am-btn-block" data-am-share-close><%= cancel %></button></div></div>'
			}, l.SNS = {
				weibo: {
					title: "\u65b0\u6d6a\u5fae\u535a",
					url: "http://service.weibo.com/share/share.php",
					width: 620,
					height: 450,
					icon: "weibo"
				},
				qq: {
					title: "QQ \u597d\u53cb",
					url: "http://connect.qq.com/widget/shareqq/index.html",
					icon: "qq"
				},
				qzone: {
					title: "QQ \u7a7a\u95f4",
					url: "http://sns.qzone.qq.com/cgi-bin/qzshare/cgi_qzshare_onekey",
					icon: "star"
				},
				tqq: {
					title: "\u817e\u8baf\u5fae\u535a",
					url: "http://v.t.qq.com/share/share.php",
					icon: "tencent-weibo"
				},
				wechat: {
					title: "\u5fae\u4fe1",
					url: "[qrcode]",
					icon: "wechat"
				},
				renren: {
					title: "\u4eba\u4eba\u7f51",
					url: "http://widget.renren.com/dialog/share",
					icon: "renren"
				},
				douban: {
					title: "\u8c46\u74e3",
					url: "http://www.douban.com/recommend/",
					icon: "share-alt"
				},
				mail: {
					title: "\u90ae\u4ef6\u5206\u4eab",
					url: "mailto:",
					icon: "envelope-o"
				},
				sms: {
					title: "\u77ed\u4fe1\u5206\u4eab",
					url: "sms:",
					icon: "comment"
				}
			}, l.prototype.render = function() {
				var t = this.options,
					e = [],
					i = encodeURIComponent(a.title),
					o = encodeURIComponent(a.location),
					r = "?body=" + i + o;
				return t.sns.forEach(function(n, s) {
					if(l.SNS[n]) {
						var a, c = l.SNS[n];
						c.id = n, a = "mail" === n ? r + "&subject=" + t.desc : "sms" === n ? r : "?url=" + o + "&title=" + i, c.shareUrl = c.url + a, e.push(c)
					}
				}), s.template(t.tpl, n.extend({}, t, {
					sns: e
				}))
			}, l.prototype.init = function() {
				if(!this.inited) {
					var t = this,
						e = "[data-am-share-to]";
					r.ready(n.proxy(function() {
						n("body").append(this.render()), this.$element = n("#" + this.options.id), this.$element.find("[data-am-share-close]").on("click.share.amui", function() {
							t.close()
						})
					}, this)), r.on("click.share.amui", e, n.proxy(function(t) {
						var i = n(t.target),
							s = i.is(e) && i || i.parent(e),
							o = s.attr("data-am-share-to");
						"mail" !== o && "sms" !== o && (t.preventDefault(), this.shareTo(o, this.setData(o))), this.close()
					}, this)), this.inited = !0
				}
			}, l.prototype.open = function() {
				!this.inited && this.init(), this.$element && this.$element.modal("open"), this.$element.trigger("open.share.amui"), this.active = !0
			}, l.prototype.close = function() {
				this.$element && this.$element.modal("close"), this.$element.trigger("close.share.amui"), this.active = !1
			}, l.prototype.toggle = function() {
				this.active ? this.close() : this.open()
			}, l.prototype.setData = function(t) {
				if(t) {
					var e = {
							url: a.location,
							title: a.title
						},
						i = this.options.desc,
						n = this.pics || [],
						s = /^(qzone|qq|tqq)$/;
					if(s.test(t) && !n.length) {
						for(var o = a.images, r = 0; r < o.length && 10 > r; r++) !!o[r].src && n.push(encodeURIComponent(o[r].src));
						this.pics = n
					}
					switch(t) {
						case "qzone":
							e.desc = i, e.site = this.options.via, e.pics = n.join("|");
							break;
						case "qq":
							e.desc = i, e.site = this.options.via, e.pics = n[0];
							break;
						case "tqq":
							e.pic = n.join("|")
					}
					return e
				}
			}, l.prototype.shareTo = function(t, e) {
				var i = l.SNS[t];
				if(i) {
					if("wechat" === t || "weixin" === t) return this.wechatQr();
					var n = [];
					for(var s in e) e[s] && n.push(s.toString() + "=" + ("pic" === s || "pics" === s ? e[s] : encodeURIComponent(e[s])));
					window.open(i.url + "?" + n.join("&"))
				}
			}, l.prototype.wechatQr = function() {
				if(!this.$wechatQr) {
					var t = s.utils.generateGUID("am-share-wechat"),
						e = n('<div class="am-modal am-modal-no-btn am-share-wechat-qr"><div class="am-modal-dialog"><div class="am-modal-hd">\u5206\u4eab\u5230\u5fae\u4fe1 <a href="" class="am-close am-close-spin" data-am-modal-close>&times;</a> </div><div class="am-modal-bd"><div class="am-share-wx-qr"></div><div class="am-share-wechat-tip">\u6253\u5f00\u5fae\u4fe1\uff0c\u70b9\u51fb\u5e95\u90e8\u7684<em>\u53d1\u73b0</em>\uff0c<br/> \u4f7f\u7528<em>\u626b\u4e00\u626b</em>\u5c06\u7f51\u9875\u5206\u4eab\u81f3\u670b\u53cb\u5708</div></div></div></div>');
					e.attr("id", t);
					var i = new o({
						render: "canvas",
						correctLevel: 0,
						text: a.location.href,
						width: 180,
						height: 180,
						background: "#fff",
						foreground: "#000"
					});
					e.find(".am-share-wx-qr").html(i), e.appendTo(n("body")), this.$wechatQr = n("#" + t)
				}
				this.$wechatQr.modal("open")
			};
			var c = new l;
			r.on("click.share.amui.data-api", '[data-am-toggle="share"]', function(t) {
				t.preventDefault(), c.toggle()
			}), e.exports = s.share = c
		}, {
			12: 12,
			2: 2,
			31: 31
		}],
		22: [function(t, e, i) {
			"use strict";
			var n = window.jQuery,
				s = t(2),
				o = s.utils.rAF,
				a = s.utils.cancelAF,
				r = !1,
				l = function(t, e) {
					function i(t) {
						return(t /= .5) < 1 ? .5 * Math.pow(t, 5) : .5 * (Math.pow(t - 2, 5) + 2)
					}

					function s() {
						p.off("touchstart.smoothscroll.amui", y), r = !1
					}

					function c(t) {
						r && (u || (u = t), h = Math.min(1, Math.max((t - u) / w, 0)), d = Math.round(f + g * i(h)), g > 0 && d > m && (d = m), 0 > g && m > d && (d = m), v != d && p.scrollTop(d), v = d, d !== m ? (a(b), b = o(c)) : (a(b), s()))
					}
					e = e || {};
					var u, h, d, p = n(t),
						m = parseInt(e.position) || l.DEFAULTS.position,
						f = p.scrollTop(),
						v = f,
						g = m - f,
						w = e.speed || Math.min(750, Math.min(1500, Math.abs(f - m))),
						y = function() {
							s()
						};
					if(!r && 0 !== g) {
						p.on("touchstart.smoothscroll.amui", y), r = !0;
						var b = o(c)
					}
				};
			l.DEFAULTS = {
				position: 0
			}, n.fn.smoothScroll = function(t) {
				return this.each(function() {
					new l(this, t)
				})
			}, n(document).on("click.smoothScroll.amui.data-api", "[data-am-smooth-scroll]", function(t) {
				t.preventDefault();
				var e = s.utils.parseOptions(n(this).data("amSmoothScroll"));
				n(window).smoothScroll(e)
			}), e.exports = l
		}, {
			2: 2
		}],
		23: [function(t, e, i) {
			"use strict";
			var n = window.jQuery,
				s = t(2),
				o = function(t, e) {
					var i = this;
					this.options = n.extend({}, o.DEFAULTS, e), this.$element = n(t), this.sticked = null, this.inited = null, this.$holder = void 0, this.$window = n(window).on("scroll.sticky.amui", s.utils.debounce(n.proxy(this.checkPosition, this), 10)).on("resize.sticky.amui orientationchange.sticky.amui", s.utils.debounce(function() {
						i.reset(!0, function() {
							i.checkPosition()
						})
					}, 50)).on("load.sticky.amui", n.proxy(this.checkPosition, this)), this.offset = this.$element.offset(), this.init()
				};
			o.DEFAULTS = {
				top: 0,
				bottom: 0,
				animation: "",
				className: {
					sticky: "am-sticky",
					resetting: "am-sticky-resetting",
					stickyBtm: "am-sticky-bottom",
					animationRev: "am-animation-reverse"
				}
			}, o.prototype.init = function() {
				var t = this.check();
				if(!t) return !1;
				var e = this.$element,
					i = "";
				n.each(e.css(["marginTop", "marginRight", "marginBottom", "marginLeft"]), function(t, e) {
					return i += " " + e
				});
				var s = n('<div class="am-sticky-placeholder"></div>').css({
					height: "absolute" !== e.css("position") ? e.outerHeight() : "",
					"float": "none" != e.css("float") ? e.css("float") : "",
					margin: i
				});
				return this.$holder = e.css("margin", 0).wrap(s).parent(), this.inited = 1, !0
			}, o.prototype.reset = function(t, e) {
				var i = this.options,
					n = this.$element,
					o = i.animation ? " am-animation-" + i.animation : "",
					a = function() {
						n.css({
							position: "",
							top: "",
							width: "",
							left: "",
							margin: 0
						}), n.removeClass([o, i.className.animationRev, i.className.sticky, i.className.resetting].join(" ")), this.animating = !1, this.sticked = !1, this.offset = n.offset(), e && e()
					}.bind(this);
				n.addClass(i.className.resetting), !t && i.animation && s.support.animation ? (this.animating = !0, n.removeClass(o).one(s.support.animation.end, function() {
					a()
				}).width(), n.addClass(o + " " + i.className.animationRev)) : a()
			}, o.prototype.check = function() {
				if(!this.$element.is(":visible")) return !1;
				var t = this.options.media;
				if(t) switch(typeof t) {
					case "number":
						if(window.innerWidth < t) return !1;
						break;
					case "string":
						if(window.matchMedia && !window.matchMedia(t).matches) return !1
				}
				return !0
			}, o.prototype.checkPosition = function() {
				if(!this.inited) {
					var t = this.init();
					if(!t) return
				}
				var e = this.options,
					i = this.$window.scrollTop(),
					n = e.top,
					s = e.bottom,
					o = this.$element,
					a = e.animation ? " am-animation-" + e.animation : "",
					r = [e.className.sticky, a].join(" ");
				"function" == typeof s && (s = s(this.$element));
				var l = i > this.$holder.offset().top;
				!this.sticked && l ? o.addClass(r) : this.sticked && !l && this.reset(), this.$holder.css({
					height: o.is(":visible") && "absolute" !== o.css("position") ? o.outerHeight() : ""
				}), l && o.css({
					top: n,
					left: this.$holder.offset().left,
					width: this.$holder.width()
				}), this.sticked = l
			}, s.plugin("sticky", o), n(window).on("load", function() {
				n("[data-am-sticky]").sticky()
			}), e.exports = o
		}, {
			2: 2
		}],
		24: [function(t, e, i) {
			"use strict";

			function n(t) {
				var e, i = Array.prototype.slice.call(arguments, 1);
				return this.each(function() {
					var n = s(this),
						a = n.is(".am-tabs") && n || n.closest(".am-tabs"),
						r = a.data("amui.tabs"),
						l = s.extend({}, o.utils.parseOptions(n.data("amTabs")), s.isPlainObject(t) && t);
					r || a.data("amui.tabs", r = new c(a[0], l)), "string" == typeof t && ("open" === t && n.is(".am-tabs-nav a") ? r.open(n) : e = "function" == typeof r[t] ? r[t].apply(r, i) : r[t])
				}), void 0 === e ? this : e
			}
			var s = window.jQuery,
				o = t(2),
				a = t(30),
				r = o.support.transition,
				l = o.support.animation,
				c = function(t, e) {
					this.$element = s(t), this.options = s.extend({}, c.DEFAULTS, e || {}), this.transitioning = this.activeIndex = null, this.refresh(), this.init()
				};
			c.DEFAULTS = {
				selector: {
					nav: "> .am-tabs-nav",
					content: "> .am-tabs-bd",
					panel: "> .am-tab-panel"
				},
				activeClass: "am-active"
			}, c.prototype.refresh = function() {
				var t = this.options.selector;
				this.$tabNav = this.$element.find(t.nav), this.$navs = this.$tabNav.find("a"), this.$content = this.$element.find(t.content), this.$tabPanels = this.$content.find(t.panel);
				var e = this.$tabNav.find("> ." + this.options.activeClass);
				1 !== e.length ? this.open(0) : this.activeIndex = this.$navs.index(e.children("a"))
			}, c.prototype.init = function() {
				var t = this,
					e = this.options;
				if(this.$element.on("click.tabs.amui", e.selector.nav + " a", function(e) {
						e.preventDefault(), t.open(s(this))
					}), !e.noSwipe) {
					if(!this.$content.length) return this;

					var i = new a.Manager(this.$content[0]),
						n = new a.Swipe({
							direction: a.DIRECTION_HORIZONTAL
						});
					i.add(n), i.on("swipeleft", o.utils.debounce(function(e) {
						e.preventDefault(), t.goTo("next")
					}, 100)), i.on("swiperight", o.utils.debounce(function(e) {
						e.preventDefault(), t.goTo("prev")
					}, 100)), this._hammer = i
				}
			}, c.prototype.open = function(t) {
				var e = this.options.activeClass,
					i = "number" == typeof t ? t : this.$navs.index(s(t));
				if(t = "number" == typeof t ? this.$navs.eq(i) : s(t), t && t.length && !this.transitioning && !t.parent("li").hasClass(e)) {
					var n = this.$tabNav,
						o = t.attr("href"),
						a = /^#.+$/,
						r = a.test(o) && this.$content.find(o) || this.$tabPanels.eq(i),
						l = n.find("." + e + " a")[0],
						c = s.Event("open.tabs.amui", {
							relatedTarget: l
						});
					t.trigger(c), c.isDefaultPrevented() || (this.activate(t.closest("li"), n), this.activate(r, this.$content, function() {
						t.trigger({
							type: "opened.tabs.amui",
							relatedTarget: l
						})
					}), this.activeIndex = i)
				}
			}, c.prototype.activate = function(t, e, i) {
				this.transitioning = !0;
				var n = this.options.activeClass,
					o = e.find("> ." + n),
					a = i && r && !!o.length;
				o.removeClass(n + " am-in"), t.addClass(n), a ? (t.redraw(), t.addClass("am-in")) : t.removeClass("am-fade");
				var l = s.proxy(function() {
					i && i(), this.transitioning = !1
				}, this);
				a ? o.one(r.end, l) : l()
			}, c.prototype.goTo = function(t) {
				var e = this.activeIndex,
					i = "next" === t,
					n = i ? "am-animation-right-spring" : "am-animation-left-spring";
				if(i && e + 1 >= this.$navs.length || !i && 0 === e) {
					var s = this.$tabPanels.eq(e);
					l && s.addClass(n).on(l.end, function() {
						s.removeClass(n)
					})
				} else this.open(i ? e + 1 : e - 1)
			}, c.prototype.destroy = function() {
				this.$element.off(".tabs.amui"), a.off(this.$content[0], "swipeleft swiperight"), this._hammer && this._hammer.destroy(), s.removeData(this.$element, "amui.tabs")
			}, s.fn.tabs = n, o.ready(function(t) {
				s("[data-am-tabs]", t).tabs()
			}), s(document).on("click.tabs.amui.data-api", "[data-am-tabs] .am-tabs-nav a", function(t) {
				t.preventDefault(), n.call(s(this), "open")
			}), e.exports = o.tabs = c
		}, {
			2: 2,
			30: 30
		}],
		25: [function(t, e, i) {
			"use strict";
			var n = window.jQuery,
				s = t(2),
				o = function(t, e) {
					this.options = n.extend({}, o.DEFAULTS, e), this.$element = n(t), this.init()
				};
			o.DEFAULTS = {
				checkboxClass: "am-ucheck-checkbox",
				radioClass: "am-ucheck-radio",
				checkboxTpl: '<span class="am-ucheck-icons"><i class="am-icon-unchecked"></i><i class="am-icon-checked"></i></span>',
				radioTpl: '<span class="am-ucheck-icons"><i class="am-icon-unchecked"></i><i class="am-icon-checked"></i></span>'
			}, o.prototype.init = function() {
				var t = this.$element,
					e = t[0],
					i = this.options;
				"checkbox" === e.type ? t.addClass(i.checkboxClass).after(i.checkboxTpl) : "radio" === e.type && t.addClass(i.radioClass).after(i.radioTpl)
			}, o.prototype.check = function() {
				this.$element.prop("checked", !0).trigger("change.ucheck.amui").trigger("checked.ucheck.amui")
			}, o.prototype.uncheck = function() {
				this.$element.prop("checked", !1).trigger("change.ucheck.amui").trigger("unchecked.ucheck.amui")
			}, o.prototype.toggle = function() {
				this.$element.prop("checked", function(t, e) {
					return !e
				}).trigger("change.ucheck.amui").trigger("toggled.ucheck.amui")
			}, o.prototype.disable = function() {
				this.$element.prop("disabled", !0).trigger("change.ucheck.amui").trigger("disabled.ucheck.amui")
			}, o.prototype.enable = function() {
				this.$element.prop("disabled", !1), this.$element.trigger("change.ucheck.amui").trigger("enabled.ucheck.amui")
			}, o.prototype.destroy = function() {
				this.$element.removeData("amui.ucheck").removeClass(this.options.checkboxClass + " " + this.options.radioClass).next(".am-ucheck-icons").remove().end().trigger("destroyed.ucheck.amui")
			}, s.plugin("uCheck", o, {
				after: function() {
					s.support.touch && this.parent().hover(function() {
						this.addClass("am-nohover")
					}, function() {
						this.removeClass("am-nohover")
					})
				}
			}), s.ready(function(t) {
				n("[data-am-ucheck]", t).uCheck()
			}), e.exports = o
		}, {
			2: 2
		}],
		26: [function(t, e, i) {
			"use strict";
			var n = window.jQuery,
				s = t(2),
				o = function(t, e) {
					this.options = n.extend({}, o.DEFAULTS, e), this.options.patterns = n.extend({}, o.patterns, this.options.patterns);
					var i = this.options.locales;
					!o.validationMessages[i] && (this.options.locales = "zh_CN"), this.$element = n(t), this.init()
				};
			o.DEFAULTS = {
				debug: !1,
				locales: "zh_CN",
				H5validation: !1,
				H5inputType: ["email", "url", "number"],
				patterns: {},
				patternClassPrefix: "js-pattern-",
				activeClass: "am-active",
				inValidClass: "am-field-error",
				validClass: "am-field-valid",
				validateOnSubmit: !0,
				allFields: ":input:visible:not(:submit, :button, :disabled, .am-novalidate)",
				customEvents: "validate",
				keyboardFields: ":input:not(:submit, :button, :disabled, .am-novalidate)",
				keyboardEvents: "focusout, change",
				activeKeyup: !1,
				textareaMaxlenthKeyup: !0,
				pointerFields: 'input[type="range"]:not(:disabled, .am-novalidate), input[type="radio"]:not(:disabled, .am-novalidate), input[type="checkbox"]:not(:disabled, .am-novalidate), select:not(:disabled, .am-novalidate), option:not(:disabled, .am-novalidate)',
				pointerEvents: "click",
				onValid: function(t) {},
				onInValid: function(t) {},
				markValid: function(t) {
					var e = this.options,
						i = n(t.field),
						s = i.closest(".am-form-group");
					i.addClass(e.validClass).removeClass(e.inValidClass), s.addClass("am-form-success").removeClass("am-form-error"), e.onValid.call(this, t)
				},
				markInValid: function(t) {
					var e = this.options,
						i = n(t.field),
						s = i.closest(".am-form-group");
					i.addClass(e.inValidClass + " " + e.activeClass).removeClass(e.validClass), s.addClass("am-form-error").removeClass("am-form-success"), e.onInValid.call(this, t)
				},
				validate: function(t) {},
				submit: null
			}, o.VERSION = "2.4.1", o.patterns = {
				email: /^((([a-zA-Z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+(\.([a-zA-Z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+)*)|((\x22)((((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(([\x01-\x08\x0b\x0c\x0e-\x1f\x7f]|\x21|[\x23-\x5b]|[\x5d-\x7e]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(\\([\x01-\x09\x0b\x0c\x0d-\x7f]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]))))*(((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(\x22)))@((([a-zA-Z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-zA-Z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-zA-Z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-zA-Z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.)+(([a-zA-Z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-zA-Z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-zA-Z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-zA-Z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.?$/,
				url: /^(https?|ftp):\/\/(((([a-zA-Z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:)*@)?(((\d|[1-9]\d|1\d\d|2[0-4]\d|25[0-5])\.(\d|[1-9]\d|1\d\d|2[0-4]\d|25[0-5])\.(\d|[1-9]\d|1\d\d|2[0-4]\d|25[0-5])\.(\d|[1-9]\d|1\d\d|2[0-4]\d|25[0-5]))|((([a-zA-Z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-zA-Z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-zA-Z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-zA-Z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.)+(([a-zA-Z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-zA-Z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-zA-Z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-zA-Z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.?)(:\d*)?)(\/((([a-zA-Z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:|@)+(\/(([a-zA-Z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:|@)*)*)?)?(\?((([a-zA-Z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:|@)|[\uE000-\uF8FF]|\/|\?)*)?(\#((([a-zA-Z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:|@)|\/|\?)*)?$/,
				number: /^-?(?:\d+|\d{1,3}(?:,\d{3})+)?(?:\.\d+)?$/,
				dateISO: /^\d{4}[\/\-]\d{1,2}[\/\-]\d{1,2}$/,
				integer: /^-?\d+$/
			}, o.validationMessages = {
				zh_CN: {
					valueMissing: "\u8bf7\u586b\u5199\uff08\u9009\u62e9\uff09\u6b64\u5b57\u6bb5",
					customError: {
						tooShort: "\u81f3\u5c11\u586b\u5199 %s \u4e2a\u5b57\u7b26",
						checkedOverflow: "\u81f3\u591a\u9009\u62e9 %s \u9879",
						checkedUnderflow: "\u81f3\u5c11\u9009\u62e9 %s \u9879"
					},
					patternMismatch: "\u8bf7\u6309\u7167\u8981\u6c42\u7684\u683c\u5f0f\u586b\u5199",
					rangeOverflow: "\u8bf7\u586b\u5199\u5c0f\u4e8e\u7b49\u4e8e %s \u7684\u503c",
					rangeUnderflow: "\u8bf7\u586b\u5199\u5927\u4e8e\u7b49\u4e8e %s \u7684\u503c",
					stepMismatch: "",
					tooLong: "\u81f3\u591a\u586b\u5199 %s \u4e2a\u5b57\u7b26",
					typeMismatch: "\u8bf7\u6309\u7167\u8981\u6c42\u7684\u7c7b\u578b\u586b\u5199"
				}
			}, o.ERROR_MAP = {
				tooShort: "minlength",
				checkedOverflow: "maxchecked",
				checkedUnderflow: "minchecked",
				rangeOverflow: "max",
				rangeUnderflow: "min",
				tooLong: "maxlength"
			}, o.prototype.init = function() {
				function t(t) {
					var e = t.toString();
					return e.substring(1, e.length - 1)
				}

				function e(t, e, a) {
					var r = e.split(","),
						l = function(t) {
							i.validate(this)
						};
					a && (l = s.utils.debounce(l, a)), n.each(r, function(e, i) {
						o.on(i + ".validator.amui", t, l)
					})
				}
				var i = this,
					o = this.$element,
					a = this.options;
				return a.H5validation && s.support.formValidation ? !1 : (o.attr("novalidate", "novalidate"), n.each(a.H5inputType, function(e, i) {
					var n = o.find("input[type=" + i + "]");
					n.attr("pattern") || n.is("[class*=" + a.patternClassPrefix + "]") || n.attr("pattern", t(a.patterns[i]))
				}), n.each(a.patterns, function(e, i) {
					var n = o.find("." + a.patternClassPrefix + e);
					!n.attr("pattern") && n.attr("pattern", t(i))
				}), o.submit(function(t) {
					if("function" == typeof a.submit) return a.submit.call(i, t);
					if(a.validateOnSubmit) {
						var e = i.isFormValid();
						return "boolean" === n.type(e) ? e : o.data("amui.checked") ? !0 : (n.when(e).then(function() {
							o.data("amui.checked", !0).submit()
						}, function() {
							o.data("amui.checked", !1).find("." + a.inValidClass).eq(0).focus()
						}), !1)
					}
				}), e(":input", a.customEvents), e(a.keyboardFields, a.keyboardEvents), e(a.pointerFields, a.pointerEvents), a.textareaMaxlenthKeyup && e("textarea[maxlength]", "keyup", 50), void(a.activeKeyup && e(".am-active", "keyup", 50)))
			}, o.prototype.isValid = function(t) {
				var e = n(t);
				return void 0 === e.data("validity") && this.validate(t), e.data("validity") && e.data("validity").valid
			}, o.prototype.validate = function(t) {
				var e = this,
					i = this.$element,
					s = this.options,
					o = n(t),
					a = o.data("equalTo");
				a && o.attr("pattern", "^" + i.find(a).val() + "$");
				var r = o.attr("pattern") || !1,
					l = new RegExp(r),
					c = null,
					u = null,
					h = o.is("[type=checkbox]") ? (u = i.find('input[name="' + t.name + '"]')).filter(":checked").length : o.is("[type=radio]") ? (c = this.$element.find('input[name="' + t.name + '"]')).filter(":checked").length > 0 : o.val();
				o = u && u.length ? u.first() : o;
				var d = void 0 !== o.attr("required") && "false" !== o.attr("required"),
					p = parseInt(o.attr("maxlength"), 10),
					m = parseInt(o.attr("minlength"), 10),
					f = Number(o.attr("min")),
					v = Number(o.attr("max")),
					g = this.createValidity({
						field: o[0],
						valid: !0
					});
				if(s.debug && window.console && (console.log("Validate: value -> [" + h + ", regex -> [" + l + "], required -> " + d), console.log("Regex test: " + l.test(h) + ", Pattern: " + r)), !isNaN(p) && h.length > p && (g.valid = !1, g.tooLong = !0), !isNaN(m) && h.length < m && (g.valid = !1, g.customError = "tooShort"), !isNaN(f) && Number(h) < f && (g.valid = !1, g.rangeUnderflow = !0), !isNaN(v) && Number(h) > v && (g.valid = !1, g.rangeOverflow = !0), d && !h) g.valid = !1, g.valueMissing = !0;
				else if((u || o.is('select[multiple="multiple"]')) && h) {
					h = u ? h : h.length;
					var w = parseInt(o.attr("minchecked"), 10),
						y = parseInt(o.attr("maxchecked"), 10);
					!isNaN(w) && w > h && (g.valid = !1, g.customError = "checkedUnderflow"), !isNaN(y) && h > y && (g.valid = !1, g.customError = "checkedOverflow")
				} else r && !l.test(h) && h && (g.valid = !1, g.patternMismatch = !0);
				var b, T = function(t) {
					this.markField(t), o.trigger("validated.field.validator.amui", t).data("validity", t);
					var i = c || u;
					return i && i.not(o).data("validity", t).each(function() {
						t.field = this, e.markField(t)
					}), t
				};
				if("function" == typeof s.validate && (b = s.validate.call(this, g)), b) {
					var x = new n.Deferred;
					return o.data("amui.dfdValidity", x.promise()), n.when(b).always(function(t) {
						x[t.valid ? "resolve" : "reject"](t), T.call(e, t)
					})
				}
				T.call(this, g)
			}, o.prototype.markField = function(t) {
				var e = this.options,
					i = "mark" + (t.valid ? "" : "In") + "Valid";
				e[i] && e[i].call(this, t)
			}, o.prototype.validateForm = function() {
				var t = this,
					e = this.$element,
					i = this.options,
					s = e.find(i.allFields),
					o = [],
					a = !0,
					r = [],
					l = n([]),
					c = [],
					u = !1;
				e.trigger("validate.form.validator.amui");
				var h = s.filter(function(t) {
					var e;
					if("INPUT" === this.tagName && "radio" === this.type) {
						if(e = this.name, o[e] === !0) return !1;
						o[e] = !0
					}
					return !0
				});
				h.each(function() {
					var i = n(this),
						s = t.isValid(this),
						o = i.data("validity");
					a = !!s && a, r.push(o), s || (l = l.add(n(this), e));
					var h = i.data("amui.dfdValidity");
					if(h) c.push(h), u = !0;
					else {
						var d = new n.Deferred;
						c.push(d.promise()), d[s ? "resolve" : "reject"](o)
					}
				});
				var d = {
					valid: a,
					$invalidFields: l,
					validity: r,
					promises: c,
					async: u
				};
				return e.trigger("validated.form.validator.amui", d), d
			}, o.prototype.isFormValid = function() {
				var t = this,
					e = this.validateForm(),
					i = function(e) {
						t.$element.trigger(e + ".validator.amui")
					};
				if(e.async) {
					var s = new n.Deferred;
					return n.when.apply(null, e.promises).then(function() {
						s.resolve(), i("valid")
					}, function() {
						s.reject(), i("invalid")
					}), s.promise()
				}
				return e.valid ? (i("valid"), !0) : (e.$invalidFields.first().focus(), i("invalid"), !1)
			}, o.prototype.createValidity = function(t) {
				return n.extend({
					customError: t.customError || !1,
					patternMismatch: t.patternMismatch || !1,
					rangeOverflow: t.rangeOverflow || !1,
					rangeUnderflow: t.rangeUnderflow || !1,
					stepMismatch: t.stepMismatch || !1,
					tooLong: t.tooLong || !1,
					typeMismatch: t.typeMismatch || !1,
					valid: t.valid || !0,
					valueMissing: t.valueMissing || !1
				}, t)
			}, o.prototype.getValidationMessage = function(t) {
				var e, i, s = o.validationMessages[this.options.locales],
					a = "%s",
					r = n(t.field);
				return(r.is('[type="checkbox"]') || r.is('[type="radio"]')) && (r = this.$element.find("[name=" + r.attr("name") + "]").first()), n.each(t, function(t, i) {
					return "field" === t || "valid" === t ? t : "customError" === t && i ? (e = i, s = s.customError, !1) : i === !0 ? (e = t, !1) : void 0
				}), i = s[e] || void 0, i && o.ERROR_MAP[e] && (i = i.replace(a, r.attr(o.ERROR_MAP[e]) || "\u89c4\u5b9a\u7684")), i
			}, o.prototype.removeMark = function() {
				this.$element.find(".am-form-success, .am-form-error, .am-field-error").removeClass("am-form-success am-form-error am-field-error")
			}, s.plugin("validator", o), s.ready(function(t) {
				n("[data-am-validator]", t).validator()
			}), e.exports = o
		}, {
			2: 2
		}],
		27: [function(t, e, i) {
			"use strict";
			var n = t(2),
				s = {
					get: function(t) {
						var e, i = encodeURIComponent(t) + "=",
							n = document.cookie.indexOf(i),
							s = null;
						return n > -1 && (e = document.cookie.indexOf(";", n), -1 == e && (e = document.cookie.length), s = decodeURIComponent(document.cookie.substring(n + i.length, e))), s
					},
					set: function(t, e, i, n, s, o) {
						var a = encodeURIComponent(t) + "=" + encodeURIComponent(e);
						i instanceof Date && (a += "; expires=" + i.toUTCString()), n && (a += "; path=" + n), s && (a += "; domain=" + s), o && (a += "; secure"), document.cookie = a
					},
					unset: function(t, e, i, n) {
						this.set(t, "", new Date(0), e, i, n)
					}
				};
			n.utils = n.utils || {}, e.exports = n.utils.cookie = s
		}, {
			2: 2
		}],
		28: [function(t, e, i) {
			"use strict";
			var n = t(2),
				s = function() {
					var t = "undefined" != typeof Element && "ALLOW_KEYBOARD_INPUT" in Element,
						e = function() {
							for(var t, e, i = [
									["requestFullscreen", "exitFullscreen", "fullscreenElement", "fullscreenEnabled", "fullscreenchange", "fullscreenerror"],
									["webkitRequestFullscreen", "webkitExitFullscreen", "webkitFullscreenElement", "webkitFullscreenEnabled", "webkitfullscreenchange", "webkitfullscreenerror"],
									["webkitRequestFullScreen", "webkitCancelFullScreen", "webkitCurrentFullScreenElement", "webkitCancelFullScreen", "webkitfullscreenchange", "webkitfullscreenerror"],
									["mozRequestFullScreen", "mozCancelFullScreen", "mozFullScreenElement", "mozFullScreenEnabled", "mozfullscreenchange", "mozfullscreenerror"],
									["msRequestFullscreen", "msExitFullscreen", "msFullscreenElement", "msFullscreenEnabled", "MSFullscreenChange", "MSFullscreenError"]
								], n = 0, s = i.length, o = {}; s > n; n++)
								if(t = i[n], t && t[1] in document) {
									for(n = 0, e = t.length; e > n; n++) o[i[0][n]] = t[n];
									return o
								}
							return !1
						}(),
						i = {
							request: function(i) {
								var n = e.requestFullscreen;
								i = i || document.documentElement, /5\.1[\.\d]* Safari/.test(navigator.userAgent) ? i[n]() : i[n](t && Element.ALLOW_KEYBOARD_INPUT)
							},
							exit: function() {
								document[e.exitFullscreen]()
							},
							toggle: function(t) {
								this.isFullscreen ? this.exit() : this.request(t)
							},
							raw: e
						};
					return e ? (Object.defineProperties(i, {
						isFullscreen: {
							get: function() {
								return !!document[e.fullscreenElement]
							}
						},
						element: {
							enumerable: !0,
							get: function() {
								return document[e.fullscreenElement]
							}
						},
						enabled: {
							enumerable: !0,
							get: function() {
								return !!document[e.fullscreenEnabled]
							}
						}
					}), i.VERSION = "2.0.0", i) : !1
				}();
			e.exports = n.fullscreen = s
		}, {
			2: 2
		}],
		29: [function(t, e, i) {
			"use strict";
			var n = window.jQuery,
				s = t(2);
			s.support.geolocation = window.navigator && window.navigator.geolocation;
			var o = s.support.geolocation,
				a = function(t) {
					this.options = t || {}
				};
			a.MESSAGES = {
				unsupportedBrowser: "Browser does not support location services",
				permissionDenied: "You have rejected access to your location",
				positionUnavailable: "Unable to determine your location",
				timeout: "Service timeout has been reached"
			}, a.ERROR_CODE = {
				0: "unsupportedBrowser",
				1: "permissionDenied",
				2: "positionUnavailable",
				3: "timeout"
			}, a.prototype.get = function(t) {
				var e = this;
				t = n.extend({}, this.options, t);
				var i = new n.Deferred;
				return o ? this.watchID = o.getCurrentPosition(function(t) {
					i.resolve.call(e, t)
				}, function(t) {
					i.reject(a.MESSAGES[a.ERROR_CODE[t.code]])
				}, t) : i.reject(a.MESSAGES.unsupportedBrowser), i.promise()
			}, a.prototype.watch = function(t) {
				if(o && (t = n.extend({}, this.options, t), n.isFunction(t.done))) {
					this.clearWatch();
					var e = n.isFunction(t.fail) ? t.fail : null;
					return this.watchID = o.watchPosition(t.done, e, t), this.watchID
				}
			}, a.prototype.clearWatch = function() {
				o && this.watchID && (o.clearWatch(this.watchID), this.watchID = null)
			}, e.exports = s.Geolocation = a
		}, {
			2: 2
		}],
		30: [function(t, e, i) {
			"use strict";

			function n(t, e, i) {
				return setTimeout(c(t, i), e)
			}

			function s(t, e, i) {
				return Array.isArray(t) ? (o(t, i[e], i), !0) : !1
			}

			function o(t, e, i) {
				var n;
				if(t)
					if(t.forEach) t.forEach(e, i);
					else if(void 0 !== t.length)
					for(n = 0; n < t.length;) e.call(i, t[n], n, t), n++;
				else
					for(n in t) t.hasOwnProperty(n) && e.call(i, t[n], n, t)
			}

			function a(t, e, i) {
				for(var n = Object.keys(e), s = 0; s < n.length;)(!i || i && void 0 === t[n[s]]) && (t[n[s]] = e[n[s]]), s++;
				return t
			}

			function r(t, e) {
				return a(t, e, !0)
			}

			function l(t, e, i) {
				var n, s = e.prototype;
				n = t.prototype = Object.create(s), n.constructor = t, n._super = s, i && a(n, i)
			}

			function c(t, e) {
				return function() {
					return t.apply(e, arguments)
				}
			}

			function u(t, e) {
				return typeof t == ht ? t.apply(e ? e[0] || void 0 : void 0, e) : t
			}

			function h(t, e) {
				return void 0 === t ? e : t
			}

			function d(t, e, i) {
				o(v(e), function(e) {
					t.addEventListener(e, i, !1)
				})
			}

			function p(t, e, i) {
				o(v(e), function(e) {
					t.removeEventListener(e, i, !1)
				})
			}

			function m(t, e) {
				for(; t;) {
					if(t == e) return !0;
					t = t.parentNode
				}
				return !1
			}

			function f(t, e) {
				return t.indexOf(e) > -1
			}

			function v(t) {
				return t.trim().split(/\s+/g)
			}

			function g(t, e, i) {
				if(t.indexOf && !i) return t.indexOf(e);
				for(var n = 0; n < t.length;) {
					if(i && t[n][i] == e || !i && t[n] === e) return n;
					n++
				}
				return -1
			}

			function w(t) {
				return Array.prototype.slice.call(t, 0)
			}

			function y(t, e, i) {
				for(var n = [], s = [], o = 0; o < t.length;) {
					var a = e ? t[o][e] : t[o];
					g(s, a) < 0 && n.push(t[o]), s[o] = a, o++
				}
				return i && (n = e ? n.sort(function(t, i) {
					return t[e] > i[e]
				}) : n.sort()), n
			}

			function b(t, e) {
				for(var i, n, s = e[0].toUpperCase() + e.slice(1), o = 0; o < ct.length;) {
					if(i = ct[o], n = i ? i + s : e, n in t) return n;
					o++
				}
				return void 0
			}

			function T() {
				return ft++
			}

			function x(t) {
				var e = t.ownerDocument;
				return e.defaultView || e.parentWindow
			}

			function C(t, e) {
				var i = this;
				this.manager = t, this.callback = e, this.element = t.element, this.target = t.options.inputTarget, this.domHandler = function(e) {
					u(t.options.enable, [t]) && i.handler(e)
				}, this.init()
			}

			function E(t) {
				var e, i = t.options.inputClass;
				return new(e = i ? i : wt ? _ : yt ? W : gt ? B : z)(t, S)
			}

			function S(t, e, i) {
				var n = i.pointers.length,
					s = i.changedPointers.length,
					o = e & St && n - s === 0,
					a = e & (Dt | Ft) && n - s === 0;
				i.isFirst = !!o, i.isFinal = !!a, o && (t.session = {}), i.eventType = e, k(t, i), t.emit("hammer.input", i), t.recognize(i), t.session.prevInput = i
			}

			function k(t, e) {
				var i = t.session,
					n = e.pointers,
					s = n.length;
				i.firstInput || (i.firstInput = A(e)), s > 1 && !i.firstMultiple ? i.firstMultiple = A(e) : 1 === s && (i.firstMultiple = !1);
				var o = i.firstInput,
					a = i.firstMultiple,
					r = a ? a.center : o.center,
					l = e.center = M(n);
				e.timeStamp = mt(), e.deltaTime = e.timeStamp - o.timeStamp, e.angle = I(r, l), e.distance = N(r, l), D(i, e), e.offsetDirection = P(e.deltaX, e.deltaY), e.scale = a ? L(a.pointers, n) : 1, e.rotation = a ? O(a.pointers, n) : 0, F(i, e);
				var c = t.element;
				m(e.srcEvent.target, c) && (c = e.srcEvent.target), e.target = c
			}

			function D(t, e) {
				var i = e.center,
					n = t.offsetDelta || {},
					s = t.prevDelta || {},
					o = t.prevInput || {};
				(e.eventType === St || o.eventType === Dt) && (s = t.prevDelta = {
					x: o.deltaX || 0,
					y: o.deltaY || 0
				}, n = t.offsetDelta = {
					x: i.x,
					y: i.y
				}), e.deltaX = s.x + (i.x - n.x), e.deltaY = s.y + (i.y - n.y)
			}

			function F(t, e) {
				var i, n, s, o, a = t.lastInterval || e,
					r = e.timeStamp - a.timeStamp;
				if(e.eventType != Ft && (r > Et || void 0 === a.velocity)) {
					var l = a.deltaX - e.deltaX,
						c = a.deltaY - e.deltaY,
						u = $(r, l, c);
					n = u.x, s = u.y, i = pt(u.x) > pt(u.y) ? u.x : u.y, o = P(l, c), t.lastInterval = e
				} else i = a.velocity, n = a.velocityX, s = a.velocityY, o = a.direction;
				e.velocity = i, e.velocityX = n, e.velocityY = s, e.direction = o
			}

			function A(t) {
				for(var e = [], i = 0; i < t.pointers.length;) e[i] = {
					clientX: dt(t.pointers[i].clientX),
					clientY: dt(t.pointers[i].clientY)
				}, i++;
				return {
					timeStamp: mt(),
					pointers: e,
					center: M(e),
					deltaX: t.deltaX,
					deltaY: t.deltaY
				}
			}

			function M(t) {
				var e = t.length;
				if(1 === e) return {
					x: dt(t[0].clientX),
					y: dt(t[0].clientY)
				};
				for(var i = 0, n = 0, s = 0; e > s;) i += t[s].clientX, n += t[s].clientY, s++;
				return {
					x: dt(i / e),
					y: dt(n / e)
				}
			}

			function $(t, e, i) {
				return {
					x: e / t || 0,
					y: i / t || 0
				}
			}

			function P(t, e) {
				return t === e ? At : pt(t) >= pt(e) ? t > 0 ? Mt : $t : e > 0 ? Pt : Nt
			}

			function N(t, e, i) {
				i || (i = zt);
				var n = e[i[0]] - t[i[0]],
					s = e[i[1]] - t[i[1]];
				return Math.sqrt(n * n + s * s)
			}

			function I(t, e, i) {
				i || (i = zt);
				var n = e[i[0]] - t[i[0]],
					s = e[i[1]] - t[i[1]];
				return 180 * Math.atan2(s, n) / Math.PI
			}

			function O(t, e) {
				return I(e[1], e[0], _t) - I(t[1], t[0], _t)
			}

			function L(t, e) {
				return N(e[0], e[1], _t) / N(t[0], t[1], _t)
			}

			function z() {
				this.evEl = qt, this.evWin = Wt, this.allow = !0, this.pressed = !1, C.apply(this, arguments)
			}

			function _() {
				this.evEl = Ut, this.evWin = Vt, C.apply(this, arguments), this.store = this.manager.session.pointerEvents = []
			}

			function R() {
				this.evTarget = Xt, this.evWin = Yt, this.started = !1, C.apply(this, arguments)
			}

			function q(t, e) {
				var i = w(t.touches),
					n = w(t.changedTouches);
				return e & (Dt | Ft) && (i = y(i.concat(n), "identifier", !0)), [i, n]
			}

			function W() {
				this.evTarget = Qt, this.targetIds = {}, C.apply(this, arguments)
			}

			function H(t, e) {
				var i = w(t.touches),
					n = this.targetIds;
				if(e & (St | kt) && 1 === i.length) return n[i[0].identifier] = !0, [i, i];
				var s, o, a = w(t.changedTouches),
					r = [],
					l = this.target;
				if(o = i.filter(function(t) {
						return m(t.target, l)
					}), e === St)
					for(s = 0; s < o.length;) n[o[s].identifier] = !0, s++;
				for(s = 0; s < a.length;) n[a[s].identifier] && r.push(a[s]), e & (Dt | Ft) && delete n[a[s].identifier], s++;
				return r.length ? [y(o.concat(r), "identifier", !0), r] : void 0
			}

			function B() {
				C.apply(this, arguments);
				var t = c(this.handler, this);
				this.touch = new W(this.manager, t), this.mouse = new z(this.manager, t)
			}

			function U(t, e) {
				this.manager = t, this.set(e)
			}

			function V(t) {
				if(f(t, ie)) return ie;
				var e = f(t, ne),
					i = f(t, se);
				return e && i ? ne + " " + se : e || i ? e ? ne : se : f(t, ee) ? ee : te
			}

			function j(t) {
				this.id = T(), this.manager = null, this.options = r(t || {}, this.defaults), this.options.enable = h(this.options.enable, !0), this.state = oe, this.simultaneous = {}, this.requireFail = []
			}

			function X(t) {
				return t & ue ? "cancel" : t & le ? "end" : t & re ? "move" : t & ae ? "start" : ""
			}

			function Y(t) {
				return t == Nt ? "down" : t == Pt ? "up" : t == Mt ? "left" : t == $t ? "right" : ""
			}

			function Z(t, e) {
				var i = e.manager;
				return i ? i.get(t) : t
			}

			function Q() {
				j.apply(this, arguments)
			}

			function G() {
				Q.apply(this, arguments), this.pX = null, this.pY = null
			}

			function J() {
				Q.apply(this, arguments)
			}

			function K() {
				j.apply(this, arguments), this._timer = null, this._input = null
			}

			function tt() {
				Q.apply(this, arguments)
			}

			function et() {
				Q.apply(this, arguments)
			}

			function it() {
				j.apply(this, arguments), this.pTime = !1, this.pCenter = !1, this._timer = null, this._input = null, this.count = 0
			}

			function nt(t, e) {
				return e = e || {}, e.recognizers = h(e.recognizers, nt.defaults.preset), new st(t, e)
			}

			function st(t, e) {
				e = e || {}, this.options = r(e, nt.defaults), this.options.inputTarget = this.options.inputTarget || t, this.handlers = {}, this.session = {}, this.recognizers = [], this.element = t, this.input = E(this), this.touchAction = new U(this, this.options.touchAction), ot(this, !0), o(e.recognizers, function(t) {
					var e = this.add(new t[0](t[1]));
					t[2] && e.recognizeWith(t[2]), t[3] && e.requireFailure(t[3])
				}, this)
			}

			function ot(t, e) {
				var i = t.element;
				o(t.options.cssProps, function(t, n) {
					i.style[b(i.style, n)] = e ? t : ""
				})
			}

			function at(t, e) {
				var i = document.createEvent("Event");
				i.initEvent(t, !0, !0), i.gesture = e, e.target.dispatchEvent(i)
			}
			var rt = window.jQuery,
				lt = t(2),
				ct = ["", "webkit", "moz", "MS", "ms", "o"],
				ut = document.createElement("div"),
				ht = "function",
				dt = Math.round,
				pt = Math.abs,
				mt = Date.now,
				ft = 1,
				vt = /mobile|tablet|ip(ad|hone|od)|android/i,
				gt = "ontouchstart" in window,
				wt = void 0 !== b(window, "PointerEvent"),
				yt = gt && vt.test(navigator.userAgent),
				bt = "touch",
				Tt = "pen",
				xt = "mouse",
				Ct = "kinect",
				Et = 25,
				St = 1,
				kt = 2,
				Dt = 4,
				Ft = 8,
				At = 1,
				Mt = 2,
				$t = 4,
				Pt = 8,
				Nt = 16,
				It = Mt | $t,
				Ot = Pt | Nt,
				Lt = It | Ot,
				zt = ["x", "y"],
				_t = ["clientX", "clientY"];
			C.prototype = {
				handler: function() {},
				init: function() {
					this.evEl && d(this.element, this.evEl, this.domHandler), this.evTarget && d(this.target, this.evTarget, this.domHandler), this.evWin && d(x(this.element), this.evWin, this.domHandler)
				},
				destroy: function() {
					this.evEl && p(this.element, this.evEl, this.domHandler), this.evTarget && p(this.target, this.evTarget, this.domHandler), this.evWin && p(x(this.element), this.evWin, this.domHandler)
				}
			};
			var Rt = {
					mousedown: St,
					mousemove: kt,
					mouseup: Dt
				},
				qt = "mousedown",
				Wt = "mousemove mouseup";
			l(z, C, {
				handler: function(t) {
					var e = Rt[t.type];
					e & St && 0 === t.button && (this.pressed = !0), e & kt && 1 !== t.which && (e = Dt), this.pressed && this.allow && (e & Dt && (this.pressed = !1), this.callback(this.manager, e, {
						pointers: [t],
						changedPointers: [t],
						pointerType: xt,
						srcEvent: t
					}))
				}
			});
			var Ht = {
					pointerdown: St,
					pointermove: kt,
					pointerup: Dt,
					pointercancel: Ft,
					pointerout: Ft
				},
				Bt = {
					2: bt,
					3: Tt,
					4: xt,
					5: Ct
				},
				Ut = "pointerdown",
				Vt = "pointermove pointerup pointercancel";
			window.MSPointerEvent && (Ut = "MSPointerDown", Vt = "MSPointerMove MSPointerUp MSPointerCancel"), l(_, C, {
				handler: function(t) {
					var e = this.store,
						i = !1,
						n = t.type.toLowerCase().replace("ms", ""),
						s = Ht[n],
						o = Bt[t.pointerType] || t.pointerType,
						a = o == bt,
						r = g(e, t.pointerId, "pointerId");
					s & St && (0 === t.button || a) ? 0 > r && (e.push(t), r = e.length - 1) : s & (Dt | Ft) && (i = !0), 0 > r || (e[r] = t, this.callback(this.manager, s, {
						pointers: e,
						changedPointers: [t],
						pointerType: o,
						srcEvent: t
					}), i && e.splice(r, 1))
				}
			});
			var jt = {
					touchstart: St,
					touchmove: kt,
					touchend: Dt,
					touchcancel: Ft
				},
				Xt = "touchstart",
				Yt = "touchstart touchmove touchend touchcancel";
			l(R, C, {
				handler: function(t) {
					var e = jt[t.type];
					if(e === St && (this.started = !0), this.started) {
						var i = q.call(this, t, e);
						e & (Dt | Ft) && i[0].length - i[1].length === 0 && (this.started = !1), this.callback(this.manager, e, {
							pointers: i[0],
							changedPointers: i[1],
							pointerType: bt,
							srcEvent: t
						})
					}
				}
			});
			var Zt = {
					touchstart: St,
					touchmove: kt,
					touchend: Dt,
					touchcancel: Ft
				},
				Qt = "touchstart touchmove touchend touchcancel";
			l(W, C, {
				handler: function(t) {
					var e = Zt[t.type],
						i = H.call(this, t, e);
					i && this.callback(this.manager, e, {
						pointers: i[0],
						changedPointers: i[1],
						pointerType: bt,
						srcEvent: t
					})
				}
			}), l(B, C, {
				handler: function(t, e, i) {
					var n = i.pointerType == bt,
						s = i.pointerType == xt;
					if(n) this.mouse.allow = !1;
					else if(s && !this.mouse.allow) return;
					e & (Dt | Ft) && (this.mouse.allow = !0), this.callback(t, e, i)
				},
				destroy: function() {
					this.touch.destroy(), this.mouse.destroy()
				}
			});
			var Gt = b(ut.style, "touchAction"),
				Jt = void 0 !== Gt,
				Kt = "compute",
				te = "auto",
				ee = "manipulation",
				ie = "none",
				ne = "pan-x",
				se = "pan-y";
			U.prototype = {
				set: function(t) {
					t == Kt && (t = this.compute()), Jt && (this.manager.element.style[Gt] = t), this.actions = t.toLowerCase().trim()
				},
				update: function() {
					this.set(this.manager.options.touchAction)
				},
				compute: function() {
					var t = [];
					return o(this.manager.recognizers, function(e) {
						u(e.options.enable, [e]) && (t = t.concat(e.getTouchAction()))
					}), V(t.join(" "))
				},
				preventDefaults: function(t) {
					if(!Jt) {
						var e = t.srcEvent,
							i = t.offsetDirection;
						if(this.manager.session.prevented) return void e.preventDefault();
						var n = this.actions,
							s = f(n, ie),
							o = f(n, se),
							a = f(n, ne);
						return s || o && i & It || a && i & Ot ? this.preventSrc(e) : void 0
					}
				},
				preventSrc: function(t) {
					this.manager.session.prevented = !0, t.preventDefault()
				}
			};
			var oe = 1,
				ae = 2,
				re = 4,
				le = 8,
				ce = le,
				ue = 16,
				he = 32;
			j.prototype = {
				defaults: {},
				set: function(t) {
					return a(this.options, t), this.manager && this.manager.touchAction.update(), this
				},
				recognizeWith: function(t) {
					if(s(t, "recognizeWith", this)) return this;
					var e = this.simultaneous;
					return t = Z(t, this), e[t.id] || (e[t.id] = t, t.recognizeWith(this)), this
				},
				dropRecognizeWith: function(t) {
					return s(t, "dropRecognizeWith", this) ? this : (t = Z(t, this), delete this.simultaneous[t.id], this)
				},
				requireFailure: function(t) {
					if(s(t, "requireFailure", this)) return this;
					var e = this.requireFail;
					return t = Z(t, this), -1 === g(e, t) && (e.push(t), t.requireFailure(this)), this
				},
				dropRequireFailure: function(t) {
					if(s(t, "dropRequireFailure", this)) return this;
					t = Z(t, this);
					var e = g(this.requireFail, t);
					return e > -1 && this.requireFail.splice(e, 1), this
				},
				hasRequireFailures: function() {
					return this.requireFail.length > 0
				},
				canRecognizeWith: function(t) {
					return !!this.simultaneous[t.id]
				},
				emit: function(t) {
					function e(e) {
						i.manager.emit(i.options.event + (e ? X(n) : ""), t)
					}
					var i = this,
						n = this.state;
					le > n && e(!0), e(), n >= le && e(!0)
				},
				tryEmit: function(t) {
					return this.canEmit() ? this.emit(t) : void(this.state = he)
				},
				canEmit: function() {
					for(var t = 0; t < this.requireFail.length;) {
						if(!(this.requireFail[t].state & (he | oe))) return !1;
						t++
					}
					return !0
				},
				recognize: function(t) {
					var e = a({}, t);
					return u(this.options.enable, [this, e]) ? (this.state & (ce | ue | he) && (this.state = oe), this.state = this.process(e), void(this.state & (ae | re | le | ue) && this.tryEmit(e))) : (this.reset(), void(this.state = he))
				},
				process: function(t) {},
				getTouchAction: function() {},
				reset: function() {}
			}, l(Q, j, {
				defaults: {
					pointers: 1
				},
				attrTest: function(t) {
					var e = this.options.pointers;
					return 0 === e || t.pointers.length === e
				},
				process: function(t) {
					var e = this.state,
						i = t.eventType,
						n = e & (ae | re),
						s = this.attrTest(t);
					return n && (i & Ft || !s) ? e | ue : n || s ? i & Dt ? e | le : e & ae ? e | re : ae : he
				}
			}), l(G, Q, {
				defaults: {
					event: "pan",
					threshold: 10,
					pointers: 1,
					direction: Lt
				},
				getTouchAction: function() {
					var t = this.options.direction,
						e = [];
					return t & It && e.push(se), t & Ot && e.push(ne), e
				},
				directionTest: function(t) {
					var e = this.options,
						i = !0,
						n = t.distance,
						s = t.direction,
						o = t.deltaX,
						a = t.deltaY;
					return s & e.direction || (e.direction & It ? (s = 0 === o ? At : 0 > o ? Mt : $t, i = o != this.pX, n = Math.abs(t.deltaX)) : (s = 0 === a ? At : 0 > a ? Pt : Nt, i = a != this.pY, n = Math.abs(t.deltaY))), t.direction = s, i && n > e.threshold && s & e.direction
				},
				attrTest: function(t) {
					return Q.prototype.attrTest.call(this, t) && (this.state & ae || !(this.state & ae) && this.directionTest(t))
				},
				emit: function(t) {
					this.pX = t.deltaX, this.pY = t.deltaY;
					var e = Y(t.direction);
					e && this.manager.emit(this.options.event + e, t), this._super.emit.call(this, t)
				}
			}), l(J, Q, {
				defaults: {
					event: "pinch",
					threshold: 0,
					pointers: 2
				},
				getTouchAction: function() {
					return [ie]
				},
				attrTest: function(t) {
					return this._super.attrTest.call(this, t) && (Math.abs(t.scale - 1) > this.options.threshold || this.state & ae)
				},
				emit: function(t) {
					if(this._super.emit.call(this, t), 1 !== t.scale) {
						var e = t.scale < 1 ? "in" : "out";
						this.manager.emit(this.options.event + e, t)
					}
				}
			}), l(K, j, {
				defaults: {
					event: "press",
					pointers: 1,
					time: 500,
					threshold: 5
				},
				getTouchAction: function() {
					return [te]
				},
				process: function(t) {
					var e = this.options,
						i = t.pointers.length === e.pointers,
						s = t.distance < e.threshold,
						o = t.deltaTime > e.time;
					if(this._input = t, !s || !i || t.eventType & (Dt | Ft) && !o) this.reset();
					else if(t.eventType & St) this.reset(), this._timer = n(function() {
						this.state = ce, this.tryEmit()
					}, e.time, this);
					else if(t.eventType & Dt) return ce;
					return he
				},
				reset: function() {
					clearTimeout(this._timer)
				},
				emit: function(t) {
					this.state === ce && (t && t.eventType & Dt ? this.manager.emit(this.options.event + "up", t) : (this._input.timeStamp = mt(), this.manager.emit(this.options.event, this._input)))
				}
			}), l(tt, Q, {
				defaults: {
					event: "rotate",
					threshold: 0,
					pointers: 2
				},
				getTouchAction: function() {
					return [ie]
				},
				attrTest: function(t) {
					return this._super.attrTest.call(this, t) && (Math.abs(t.rotation) > this.options.threshold || this.state & ae)
				}
			}), l(et, Q, {
				defaults: {
					event: "swipe",
					threshold: 10,
					velocity: .65,
					direction: It | Ot,
					pointers: 1
				},
				getTouchAction: function() {
					return G.prototype.getTouchAction.call(this)
				},
				attrTest: function(t) {
					var e, i = this.options.direction;
					return i & (It | Ot) ? e = t.velocity : i & It ? e = t.velocityX : i & Ot && (e = t.velocityY), this._super.attrTest.call(this, t) && i & t.direction && t.distance > this.options.threshold && pt(e) > this.options.velocity && t.eventType & Dt
				},
				emit: function(t) {
					var e = Y(t.direction);
					e && this.manager.emit(this.options.event + e, t), this.manager.emit(this.options.event, t)
				}
			}), l(it, j, {
				defaults: {
					event: "tap",
					pointers: 1,
					taps: 1,
					interval: 300,
					time: 250,
					threshold: 2,
					posThreshold: 10
				},
				getTouchAction: function() {
					return [ee]
				},
				process: function(t) {
					var e = this.options,
						i = t.pointers.length === e.pointers,
						s = t.distance < e.threshold,
						o = t.deltaTime < e.time;
					if(this.reset(), t.eventType & St && 0 === this.count) return this.failTimeout();
					if(s && o && i) {
						if(t.eventType != Dt) return this.failTimeout();
						var a = this.pTime ? t.timeStamp - this.pTime < e.interval : !0,
							r = !this.pCenter || N(this.pCenter, t.center) < e.posThreshold;

						this.pTime = t.timeStamp, this.pCenter = t.center, r && a ? this.count += 1 : this.count = 1, this._input = t;
						var l = this.count % e.taps;
						if(0 === l) return this.hasRequireFailures() ? (this._timer = n(function() {
							this.state = ce, this.tryEmit()
						}, e.interval, this), ae) : ce
					}
					return he
				},
				failTimeout: function() {
					return this._timer = n(function() {
						this.state = he
					}, this.options.interval, this), he
				},
				reset: function() {
					clearTimeout(this._timer)
				},
				emit: function() {
					this.state == ce && (this._input.tapCount = this.count, this.manager.emit(this.options.event, this._input))
				}
			}), nt.VERSION = "2.0.4", nt.defaults = {
				domEvents: !1,
				touchAction: Kt,
				enable: !0,
				inputTarget: null,
				inputClass: null,
				preset: [
					[tt, {
						enable: !1
					}],
					[J, {
							enable: !1
						},
						["rotate"]
					],
					[et, {
						direction: It
					}],
					[G, {
							direction: It
						},
						["swipe"]
					],
					[it],
					[it, {
							event: "doubletap",
							taps: 2
						},
						["tap"]
					],
					[K]
				],
				cssProps: {
					userSelect: "none",
					touchSelect: "none",
					touchCallout: "none",
					contentZooming: "none",
					userDrag: "none",
					tapHighlightColor: "rgba(0,0,0,0)"
				}
			};
			var de = 1,
				pe = 2;
			st.prototype = {
					set: function(t) {
						return a(this.options, t), t.touchAction && this.touchAction.update(), t.inputTarget && (this.input.destroy(), this.input.target = t.inputTarget, this.input.init()), this
					},
					stop: function(t) {
						this.session.stopped = t ? pe : de
					},
					recognize: function(t) {
						var e = this.session;
						if(!e.stopped) {
							this.touchAction.preventDefaults(t);
							var i, n = this.recognizers,
								s = e.curRecognizer;
							(!s || s && s.state & ce) && (s = e.curRecognizer = null);
							for(var o = 0; o < n.length;) i = n[o], e.stopped === pe || s && i != s && !i.canRecognizeWith(s) ? i.reset() : i.recognize(t), !s && i.state & (ae | re | le) && (s = e.curRecognizer = i), o++
						}
					},
					get: function(t) {
						if(t instanceof j) return t;
						for(var e = this.recognizers, i = 0; i < e.length; i++)
							if(e[i].options.event == t) return e[i];
						return null
					},
					add: function(t) {
						if(s(t, "add", this)) return this;
						var e = this.get(t.options.event);
						return e && this.remove(e), this.recognizers.push(t), t.manager = this, this.touchAction.update(), t
					},
					remove: function(t) {
						if(s(t, "remove", this)) return this;
						var e = this.recognizers;
						return t = this.get(t), e.splice(g(e, t), 1), this.touchAction.update(), this
					},
					on: function(t, e) {
						var i = this.handlers;
						return o(v(t), function(t) {
							i[t] = i[t] || [], i[t].push(e)
						}), this
					},
					off: function(t, e) {
						var i = this.handlers;
						return o(v(t), function(t) {
							e ? i[t].splice(g(i[t], e), 1) : delete i[t]
						}), this
					},
					emit: function(t, e) {
						this.options.domEvents && at(t, e);
						var i = this.handlers[t] && this.handlers[t].slice();
						if(i && i.length) {
							e.type = t, e.preventDefault = function() {
								e.srcEvent.preventDefault()
							};
							for(var n = 0; n < i.length;) i[n](e), n++
						}
					},
					destroy: function() {
						this.element && ot(this, !1), this.handlers = {}, this.session = {}, this.input.destroy(), this.element = null
					}
				}, a(nt, {
					INPUT_START: St,
					INPUT_MOVE: kt,
					INPUT_END: Dt,
					INPUT_CANCEL: Ft,
					STATE_POSSIBLE: oe,
					STATE_BEGAN: ae,
					STATE_CHANGED: re,
					STATE_ENDED: le,
					STATE_RECOGNIZED: ce,
					STATE_CANCELLED: ue,
					STATE_FAILED: he,
					DIRECTION_NONE: At,
					DIRECTION_LEFT: Mt,
					DIRECTION_RIGHT: $t,
					DIRECTION_UP: Pt,
					DIRECTION_DOWN: Nt,
					DIRECTION_HORIZONTAL: It,
					DIRECTION_VERTICAL: Ot,
					DIRECTION_ALL: Lt,
					Manager: st,
					Input: C,
					TouchAction: U,
					TouchInput: W,
					MouseInput: z,
					PointerEventInput: _,
					TouchMouseInput: B,
					SingleTouchInput: R,
					Recognizer: j,
					AttrRecognizer: Q,
					Tap: it,
					Pan: G,
					Swipe: et,
					Pinch: J,
					Rotate: tt,
					Press: K,
					on: d,
					off: p,
					each: o,
					merge: r,
					extend: a,
					inherit: l,
					bindFn: c,
					prefixed: b
				}),
				function(t, e) {
					function i(i, n) {
						var s = t(i);
						s.data("hammer") || s.data("hammer", new e(s[0], n))
					}
					t.fn.hammer = function(t) {
						return this.each(function() {
							i(this, t)
						})
					}, e.Manager.prototype.emit = function(e) {
						return function(i, n) {
							e.call(this, i, n), t(this.element).trigger({
								type: i,
								gesture: n
							})
						}
					}(e.Manager.prototype.emit)
				}(rt, nt), e.exports = lt.Hammer = nt
		}, {
			2: 2
		}],
		31: [function(t, e, i) {
			function n(t) {
				return 128 > t ? [t] : 2048 > t ? (c0 = 192 + (t >> 6), c1 = 128 + (63 & t), [c0, c1]) : (c0 = 224 + (t >> 12), c1 = 128 + (t >> 6 & 63), c2 = 128 + (63 & t), [c0, c1, c2])
			}

			function s(t) {
				for(var e = [], i = 0; i < t.length; i++)
					for(var s = t.charCodeAt(i), o = n(s), a = 0; a < o.length; a++) e.push(o[a]);
				return e
			}

			function o(t, e) {
				this.typeNumber = -1, this.errorCorrectLevel = e, this.modules = null, this.moduleCount = 0, this.dataCache = null, this.rsBlocks = null, this.totalDataCount = -1, this.data = t, this.utf8bytes = s(t), this.make()
			}

			function a(t, e) {
				if(void 0 == t.length) throw new Error(t.length + "/" + e);
				for(var i = 0; i < t.length && 0 == t[i];) i++;
				this.num = new Array(t.length - i + e);
				for(var n = 0; n < t.length - i; n++) this.num[n] = t[n + i]
			}

			function r() {
				this.buffer = new Array, this.length = 0
			}

			function n(t) {
				return 128 > t ? [t] : 2048 > t ? (c0 = 192 + (t >> 6), c1 = 128 + (63 & t), [c0, c1]) : (c0 = 224 + (t >> 12), c1 = 128 + (t >> 6 & 63), c2 = 128 + (63 & t), [c0, c1, c2])
			}

			function s(t) {
				for(var e = [], i = 0; i < t.length; i++)
					for(var s = t.charCodeAt(i), o = n(s), a = 0; a < o.length; a++) e.push(o[a]);
				return e
			}

			function o(t, e) {
				this.typeNumber = -1, this.errorCorrectLevel = e, this.modules = null, this.moduleCount = 0, this.dataCache = null, this.rsBlocks = null, this.totalDataCount = -1, this.data = t, this.utf8bytes = s(t), this.make()
			}

			function a(t, e) {
				if(void 0 == t.length) throw new Error(t.length + "/" + e);
				for(var i = 0; i < t.length && 0 == t[i];) i++;
				this.num = new Array(t.length - i + e);
				for(var n = 0; n < t.length - i; n++) this.num[n] = t[n + i]
			}

			function r() {
				this.buffer = new Array, this.length = 0
			}
			var c = window.jQuery,
				u = t(2),
				h = [],
				d = function(t) {
					"string" == typeof t && (t = {
						text: t
					}), this.options = c.extend({}, {
						text: "",
						render: "",
						width: 256,
						height: 256,
						correctLevel: 3,
						background: "#ffffff",
						foreground: "#000000"
					}, t);
					for(var e = null, i = 0, n = h.length; n > i; i++)
						if(h[i].text == this.options.text && h[i].text.correctLevel == this.options.correctLevel) {
							e = h[i].obj;
							break
						}
					if(i == n && (e = new o(this.options.text, this.options.correctLevel), h.push({
							text: this.options.text,
							correctLevel: this.options.correctLevel,
							obj: e
						})), this.options.render) switch(this.options.render) {
						case "canvas":
							return this.createCanvas(e);
						case "table":
							return this.createTable(e);
						case "svg":
							return this.createSVG(e);
						default:
							return this.createDefault(e)
					}
					return this.createDefault(e)
				};
			d.prototype.createDefault = function(t) {
				var e = document.createElement("canvas");
				return e.getContext ? this.createCanvas(t) : document.createElementNS && document.createElementNS(SVG_NS, "svg").createSVGRect ? this.createSVG(t) : this.createTable(t)
			}, d.prototype.createCanvas = function(t) {
				var e = document.createElement("canvas");
				e.width = this.options.width, e.height = this.options.height;
				for(var i = e.getContext("2d"), n = (this.options.width / t.getModuleCount()).toPrecision(4), s = this.options.height / t.getModuleCount().toPrecision(4), o = 0; o < t.getModuleCount(); o++)
					for(var a = 0; a < t.getModuleCount(); a++) {
						i.fillStyle = t.modules[o][a] ? this.options.foreground : this.options.background;
						var r = Math.ceil((a + 1) * n) - Math.floor(a * n),
							l = Math.ceil((o + 1) * n) - Math.floor(o * n);
						i.fillRect(Math.round(a * n), Math.round(o * s), r, l)
					}
				return e
			}, d.prototype.createTable = function(t) {
				var e = [];
				e.push('<table style="border:0px; margin:0px; padding:0px; border-collapse:collapse; background-color: ' + this.options.background + ';">');
				var i = -1,
					n = -1,
					s = -1,
					o = -1;
				i = s = Math.floor(this.options.width / t.getModuleCount()), n = o = Math.floor(this.options.height / t.getModuleCount()), 0 >= s && (i = t.getModuleCount() < 80 ? 2 : 1), 0 >= o && (n = t.getModuleCount() < 80 ? 2 : 1), foreTd = '<td style="border:0px; margin:0px; padding:0px; width:' + i + "px; background-color: " + this.options.foreground + '"></td>', backTd = '<td style="border:0px; margin:0px; padding:0px; width:' + i + "px; background-color: " + this.options.background + '"></td>', l = t.getModuleCount();
				for(var a = 0; a < l; a++) {
					e.push('<tr style="border:0px; margin:0px; padding:0px; height: ' + n + 'px">');
					for(var r = 0; r < l; r++) e.push(t.modules[a][r] ? foreTd : backTd);
					e.push("</tr>")
				}
				e.push("</table>");
				var c = document.createElement("span");
				return c.innerHTML = e.join(""), c.firstChild
			}, d.prototype.createSVG = function(t) {
				for(var e, i, n, s, o = t.getModuleCount(), a = this.options.height / this.options.width, r = '<svg xmlns="http://www.w3.org/2000/svg" width="' + this.options.width + 'px" height="' + this.options.height + 'px" viewbox="0 0 ' + 10 * o + " " + 10 * o * a + '">', l = "<path ", u = ' style="stroke-width:0.5;stroke:' + this.options.foreground + ";fill:" + this.options.foreground + ';"></path>', h = ' style="stroke-width:0.5;stroke:' + this.options.background + ";fill:" + this.options.background + ';"></path>', d = 0; o > d; d++)
					for(var p = 0; o > p; p++) e = 10 * p, n = 10 * d * a, i = 10 * (p + 1), s = 10 * (d + 1) * a, r += l + 'd="M ' + e + "," + n + " L " + i + "," + n + " L " + i + "," + s + " L " + e + "," + s + ' Z"', r += t.modules[d][p] ? u : h;
				return r += "</svg>", c(r)[0]
			}, o.prototype = {
				constructor: o,
				getModuleCount: function() {
					return this.moduleCount
				},
				make: function() {
					this.getRightType(), this.dataCache = this.createData(), this.createQrcode()
				},
				makeImpl: function(t) {
					this.moduleCount = 4 * this.typeNumber + 17, this.modules = new Array(this.moduleCount);
					for(var e = 0; e < this.moduleCount; e++) this.modules[e] = new Array(this.moduleCount);
					this.setupPositionProbePattern(0, 0), this.setupPositionProbePattern(this.moduleCount - 7, 0), this.setupPositionProbePattern(0, this.moduleCount - 7), this.setupPositionAdjustPattern(), this.setupTimingPattern(), this.setupTypeInfo(!0, t), this.typeNumber >= 7 && this.setupTypeNumber(!0), this.mapData(this.dataCache, t)
				},
				setupPositionProbePattern: function(t, e) {
					for(var i = -1; 7 >= i; i++)
						if(!(-1 >= t + i || this.moduleCount <= t + i))
							for(var n = -1; 7 >= n; n++) - 1 >= e + n || this.moduleCount <= e + n || (this.modules[t + i][e + n] = i >= 0 && 6 >= i && (0 == n || 6 == n) || n >= 0 && 6 >= n && (0 == i || 6 == i) || i >= 2 && 4 >= i && n >= 2 && 4 >= n ? !0 : !1)
				},
				createQrcode: function() {
					for(var t = 0, e = 0, i = null, n = 0; 8 > n; n++) {
						this.makeImpl(n);
						var s = f.getLostPoint(this);
						(0 == n || t > s) && (t = s, e = n, i = this.modules)
					}
					this.modules = i, this.setupTypeInfo(!1, e), this.typeNumber >= 7 && this.setupTypeNumber(!1)
				},
				setupTimingPattern: function() {
					for(var t = 8; t < this.moduleCount - 8; t++) null == this.modules[t][6] && (this.modules[t][6] = t % 2 == 0, null == this.modules[6][t] && (this.modules[6][t] = t % 2 == 0))
				},
				setupPositionAdjustPattern: function() {
					for(var t = f.getPatternPosition(this.typeNumber), e = 0; e < t.length; e++)
						for(var i = 0; i < t.length; i++) {
							var n = t[e],
								s = t[i];
							if(null == this.modules[n][s])
								for(var o = -2; 2 >= o; o++)
									for(var a = -2; 2 >= a; a++) this.modules[n + o][s + a] = -2 == o || 2 == o || -2 == a || 2 == a || 0 == o && 0 == a ? !0 : !1
						}
				},
				setupTypeNumber: function(t) {
					for(var e = f.getBCHTypeNumber(this.typeNumber), i = 0; 18 > i; i++) {
						var n = !t && 1 == (e >> i & 1);
						this.modules[Math.floor(i / 3)][i % 3 + this.moduleCount - 8 - 3] = n, this.modules[i % 3 + this.moduleCount - 8 - 3][Math.floor(i / 3)] = n
					}
				},
				setupTypeInfo: function(t, e) {
					for(var i = p[this.errorCorrectLevel] << 3 | e, n = f.getBCHTypeInfo(i), s = 0; 15 > s; s++) {
						var o = !t && 1 == (n >> s & 1);
						6 > s ? this.modules[s][8] = o : 8 > s ? this.modules[s + 1][8] = o : this.modules[this.moduleCount - 15 + s][8] = o;
						var o = !t && 1 == (n >> s & 1);
						8 > s ? this.modules[8][this.moduleCount - s - 1] = o : 9 > s ? this.modules[8][15 - s - 1 + 1] = o : this.modules[8][15 - s - 1] = o
					}
					this.modules[this.moduleCount - 8][8] = !t
				},
				createData: function() {
					var t = new r,
						e = this.typeNumber > 9 ? 16 : 8;
					t.put(4, 4), t.put(this.utf8bytes.length, e);
					for(var i = 0, n = this.utf8bytes.length; n > i; i++) t.put(this.utf8bytes[i], 8);
					for(t.length + 4 <= 8 * this.totalDataCount && t.put(0, 4); t.length % 8 != 0;) t.putBit(!1);
					for(;;) {
						if(t.length >= 8 * this.totalDataCount) break;
						if(t.put(o.PAD0, 8), t.length >= 8 * this.totalDataCount) break;
						t.put(o.PAD1, 8)
					}
					return this.createBytes(t)
				},
				createBytes: function(t) {
					for(var e = 0, i = 0, n = 0, s = this.rsBlock.length / 3, o = new Array, r = 0; s > r; r++)
						for(var l = this.rsBlock[3 * r + 0], c = this.rsBlock[3 * r + 1], u = this.rsBlock[3 * r + 2], h = 0; l > h; h++) o.push([u, c]);
					for(var d = new Array(o.length), p = new Array(o.length), m = 0; m < o.length; m++) {
						var v = o[m][0],
							g = o[m][1] - v;
						i = Math.max(i, v), n = Math.max(n, g), d[m] = new Array(v);
						for(var r = 0; r < d[m].length; r++) d[m][r] = 255 & t.buffer[r + e];
						e += v;
						var w = f.getErrorCorrectPolynomial(g),
							y = new a(d[m], w.getLength() - 1),
							b = y.mod(w);
						p[m] = new Array(w.getLength() - 1);
						for(var r = 0; r < p[m].length; r++) {
							var T = r + b.getLength() - p[m].length;
							p[m][r] = T >= 0 ? b.get(T) : 0
						}
					}
					for(var x = new Array(this.totalDataCount), C = 0, r = 0; i > r; r++)
						for(var m = 0; m < o.length; m++) r < d[m].length && (x[C++] = d[m][r]);
					for(var r = 0; n > r; r++)
						for(var m = 0; m < o.length; m++) r < p[m].length && (x[C++] = p[m][r]);
					return x
				},
				mapData: function(t, e) {
					for(var i = -1, n = this.moduleCount - 1, s = 7, o = 0, a = this.moduleCount - 1; a > 0; a -= 2)
						for(6 == a && a--;;) {
							for(var r = 0; 2 > r; r++)
								if(null == this.modules[n][a - r]) {
									var l = !1;
									o < t.length && (l = 1 == (t[o] >>> s & 1));
									var c = f.getMask(e, n, a - r);
									c && (l = !l), this.modules[n][a - r] = l, s--, -1 == s && (o++, s = 7)
								}
							if(n += i, 0 > n || this.moduleCount <= n) {
								n -= i, i = -i;
								break
							}
						}
				}
			}, o.PAD0 = 236, o.PAD1 = 17;
			for(var p = [1, 0, 3, 2], m = {
					PATTERN000: 0,
					PATTERN001: 1,
					PATTERN010: 2,
					PATTERN011: 3,
					PATTERN100: 4,
					PATTERN101: 5,
					PATTERN110: 6,
					PATTERN111: 7
				}, f = {
					PATTERN_POSITION_TABLE: [
						[],
						[6, 18],
						[6, 22],
						[6, 26],
						[6, 30],
						[6, 34],
						[6, 22, 38],
						[6, 24, 42],
						[6, 26, 46],
						[6, 28, 50],
						[6, 30, 54],
						[6, 32, 58],
						[6, 34, 62],
						[6, 26, 46, 66],
						[6, 26, 48, 70],
						[6, 26, 50, 74],
						[6, 30, 54, 78],
						[6, 30, 56, 82],
						[6, 30, 58, 86],
						[6, 34, 62, 90],
						[6, 28, 50, 72, 94],
						[6, 26, 50, 74, 98],
						[6, 30, 54, 78, 102],
						[6, 28, 54, 80, 106],
						[6, 32, 58, 84, 110],
						[6, 30, 58, 86, 114],
						[6, 34, 62, 90, 118],
						[6, 26, 50, 74, 98, 122],
						[6, 30, 54, 78, 102, 126],
						[6, 26, 52, 78, 104, 130],
						[6, 30, 56, 82, 108, 134],
						[6, 34, 60, 86, 112, 138],
						[6, 30, 58, 86, 114, 142],
						[6, 34, 62, 90, 118, 146],
						[6, 30, 54, 78, 102, 126, 150],
						[6, 24, 50, 76, 102, 128, 154],
						[6, 28, 54, 80, 106, 132, 158],
						[6, 32, 58, 84, 110, 136, 162],
						[6, 26, 54, 82, 110, 138, 166],
						[6, 30, 58, 86, 114, 142, 170]
					],
					G15: 1335,
					G18: 7973,
					G15_MASK: 21522,
					getBCHTypeInfo: function(t) {
						for(var e = t << 10; f.getBCHDigit(e) - f.getBCHDigit(f.G15) >= 0;) e ^= f.G15 << f.getBCHDigit(e) - f.getBCHDigit(f.G15);
						return(t << 10 | e) ^ f.G15_MASK
					},
					getBCHTypeNumber: function(t) {
						for(var e = t << 12; f.getBCHDigit(e) - f.getBCHDigit(f.G18) >= 0;) e ^= f.G18 << f.getBCHDigit(e) - f.getBCHDigit(f.G18);
						return t << 12 | e
					},
					getBCHDigit: function(t) {
						for(var e = 0; 0 != t;) e++, t >>>= 1;
						return e
					},
					getPatternPosition: function(t) {
						return f.PATTERN_POSITION_TABLE[t - 1]
					},
					getMask: function(t, e, i) {
						switch(t) {
							case m.PATTERN000:
								return(e + i) % 2 == 0;
							case m.PATTERN001:
								return e % 2 == 0;
							case m.PATTERN010:
								return i % 3 == 0;
							case m.PATTERN011:
								return(e + i) % 3 == 0;
							case m.PATTERN100:
								return(Math.floor(e / 2) + Math.floor(i / 3)) % 2 == 0;
							case m.PATTERN101:
								return e * i % 2 + e * i % 3 == 0;
							case m.PATTERN110:
								return(e * i % 2 + e * i % 3) % 2 == 0;
							case m.PATTERN111:
								return(e * i % 3 + (e + i) % 2) % 2 == 0;
							default:
								throw new Error("bad maskPattern:" + t)
						}
					},
					getErrorCorrectPolynomial: function(t) {
						for(var e = new a([1], 0), i = 0; t > i; i++) e = e.multiply(new a([1, v.gexp(i)], 0));
						return e
					},
					getLostPoint: function(t) {
						for(var e = t.getModuleCount(), i = 0, n = 0, s = 0; e > s; s++)
							for(var o = 0, a = t.modules[s][0], r = 0; e > r; r++) {
								var l = t.modules[s][r];
								if(e - 6 > r && l && !t.modules[s][r + 1] && t.modules[s][r + 2] && t.modules[s][r + 3] && t.modules[s][r + 4] && !t.modules[s][r + 5] && t.modules[s][r + 6] && (e - 10 > r ? t.modules[s][r + 7] && t.modules[s][r + 8] && t.modules[s][r + 9] && t.modules[s][r + 10] && (i += 40) : r > 3 && t.modules[s][r - 1] && t.modules[s][r - 2] && t.modules[s][r - 3] && t.modules[s][r - 4] && (i += 40)), e - 1 > s && e - 1 > r) {
									var c = 0;
									l && c++, t.modules[s + 1][r] && c++, t.modules[s][r + 1] && c++, t.modules[s + 1][r + 1] && c++, (0 == c || 4 == c) && (i += 3)
								}
								a ^ l ? o++ : (a = l, o >= 5 && (i += 3 + o - 5), o = 1), l && n++
							}
						for(var r = 0; e > r; r++)
							for(var o = 0, a = t.modules[0][r], s = 0; e > s; s++) {
								var l = t.modules[s][r];
								e - 6 > s && l && !t.modules[s + 1][r] && t.modules[s + 2][r] && t.modules[s + 3][r] && t.modules[s + 4][r] && !t.modules[s + 5][r] && t.modules[s + 6][r] && (e - 10 > s ? t.modules[s + 7][r] && t.modules[s + 8][r] && t.modules[s + 9][r] && t.modules[s + 10][r] && (i += 40) : s > 3 && t.modules[s - 1][r] && t.modules[s - 2][r] && t.modules[s - 3][r] && t.modules[s - 4][r] && (i += 40)), a ^ l ? o++ : (a = l, o >= 5 && (i += 3 + o - 5), o = 1)
							}
						var u = Math.abs(100 * n / e / e - 50) / 5;
						return i += 10 * u
					}
				}, v = {
					glog: function(t) {
						if(1 > t) throw new Error("glog(" + t + ")");
						return v.LOG_TABLE[t]
					},
					gexp: function(t) {
						for(; 0 > t;) t += 255;
						for(; t >= 256;) t -= 255;
						return v.EXP_TABLE[t]
					},
					EXP_TABLE: new Array(256),
					LOG_TABLE: new Array(256)
				}, g = 0; 8 > g; g++) v.EXP_TABLE[g] = 1 << g;
			for(var g = 8; 256 > g; g++) v.EXP_TABLE[g] = v.EXP_TABLE[g - 4] ^ v.EXP_TABLE[g - 5] ^ v.EXP_TABLE[g - 6] ^ v.EXP_TABLE[g - 8];
			for(var g = 0; 255 > g; g++) v.LOG_TABLE[v.EXP_TABLE[g]] = g;
			a.prototype = {
				get: function(t) {
					return this.num[t]
				},
				getLength: function() {
					return this.num.length
				},
				multiply: function(t) {
					for(var e = new Array(this.getLength() + t.getLength() - 1), i = 0; i < this.getLength(); i++)
						for(var n = 0; n < t.getLength(); n++) e[i + n] ^= v.gexp(v.glog(this.get(i)) + v.glog(t.get(n)));
					return new a(e, 0)
				},
				mod: function(t) {
					var e = this.getLength(),
						i = t.getLength();
					if(0 > e - i) return this;
					for(var n = new Array(e), s = 0; e > s; s++) n[s] = this.get(s);
					for(; n.length >= i;) {
						for(var o = v.glog(n[0]) - v.glog(t.get(0)), s = 0; s < t.getLength(); s++) n[s] ^= v.gexp(v.glog(t.get(s)) + o);
						for(; 0 == n[0];) n.shift()
					}
					return new a(n, 0)
				}
			};
			var w = [
				[1, 26, 19],
				[1, 26, 16],
				[1, 26, 13],
				[1, 26, 9],
				[1, 44, 34],
				[1, 44, 28],
				[1, 44, 22],
				[1, 44, 16],
				[1, 70, 55],
				[1, 70, 44],
				[2, 35, 17],
				[2, 35, 13],
				[1, 100, 80],
				[2, 50, 32],
				[2, 50, 24],
				[4, 25, 9],
				[1, 134, 108],
				[2, 67, 43],
				[2, 33, 15, 2, 34, 16],
				[2, 33, 11, 2, 34, 12],
				[2, 86, 68],
				[4, 43, 27],
				[4, 43, 19],
				[4, 43, 15],
				[2, 98, 78],
				[4, 49, 31],
				[2, 32, 14, 4, 33, 15],
				[4, 39, 13, 1, 40, 14],
				[2, 121, 97],
				[2, 60, 38, 2, 61, 39],
				[4, 40, 18, 2, 41, 19],
				[4, 40, 14, 2, 41, 15],
				[2, 146, 116],
				[3, 58, 36, 2, 59, 37],
				[4, 36, 16, 4, 37, 17],
				[4, 36, 12, 4, 37, 13],
				[2, 86, 68, 2, 87, 69],
				[4, 69, 43, 1, 70, 44],
				[6, 43, 19, 2, 44, 20],
				[6, 43, 15, 2, 44, 16],
				[4, 101, 81],
				[1, 80, 50, 4, 81, 51],
				[4, 50, 22, 4, 51, 23],
				[3, 36, 12, 8, 37, 13],
				[2, 116, 92, 2, 117, 93],
				[6, 58, 36, 2, 59, 37],
				[4, 46, 20, 6, 47, 21],
				[7, 42, 14, 4, 43, 15],
				[4, 133, 107],
				[8, 59, 37, 1, 60, 38],
				[8, 44, 20, 4, 45, 21],
				[12, 33, 11, 4, 34, 12],
				[3, 145, 115, 1, 146, 116],
				[4, 64, 40, 5, 65, 41],
				[11, 36, 16, 5, 37, 17],
				[11, 36, 12, 5, 37, 13],
				[5, 109, 87, 1, 110, 88],
				[5, 65, 41, 5, 66, 42],
				[5, 54, 24, 7, 55, 25],
				[11, 36, 12],
				[5, 122, 98, 1, 123, 99],
				[7, 73, 45, 3, 74, 46],
				[15, 43, 19, 2, 44, 20],
				[3, 45, 15, 13, 46, 16],
				[1, 135, 107, 5, 136, 108],
				[10, 74, 46, 1, 75, 47],
				[1, 50, 22, 15, 51, 23],
				[2, 42, 14, 17, 43, 15],
				[5, 150, 120, 1, 151, 121],
				[9, 69, 43, 4, 70, 44],
				[17, 50, 22, 1, 51, 23],
				[2, 42, 14, 19, 43, 15],
				[3, 141, 113, 4, 142, 114],
				[3, 70, 44, 11, 71, 45],
				[17, 47, 21, 4, 48, 22],
				[9, 39, 13, 16, 40, 14],
				[3, 135, 107, 5, 136, 108],
				[3, 67, 41, 13, 68, 42],
				[15, 54, 24, 5, 55, 25],
				[15, 43, 15, 10, 44, 16],
				[4, 144, 116, 4, 145, 117],
				[17, 68, 42],
				[17, 50, 22, 6, 51, 23],
				[19, 46, 16, 6, 47, 17],
				[2, 139, 111, 7, 140, 112],
				[17, 74, 46],
				[7, 54, 24, 16, 55, 25],
				[34, 37, 13],
				[4, 151, 121, 5, 152, 122],
				[4, 75, 47, 14, 76, 48],
				[11, 54, 24, 14, 55, 25],
				[16, 45, 15, 14, 46, 16],
				[6, 147, 117, 4, 148, 118],
				[6, 73, 45, 14, 74, 46],
				[11, 54, 24, 16, 55, 25],
				[30, 46, 16, 2, 47, 17],
				[8, 132, 106, 4, 133, 107],
				[8, 75, 47, 13, 76, 48],
				[7, 54, 24, 22, 55, 25],
				[22, 45, 15, 13, 46, 16],
				[10, 142, 114, 2, 143, 115],
				[19, 74, 46, 4, 75, 47],
				[28, 50, 22, 6, 51, 23],
				[33, 46, 16, 4, 47, 17],
				[8, 152, 122, 4, 153, 123],
				[22, 73, 45, 3, 74, 46],
				[8, 53, 23, 26, 54, 24],
				[12, 45, 15, 28, 46, 16],
				[3, 147, 117, 10, 148, 118],
				[3, 73, 45, 23, 74, 46],
				[4, 54, 24, 31, 55, 25],
				[11, 45, 15, 31, 46, 16],
				[7, 146, 116, 7, 147, 117],
				[21, 73, 45, 7, 74, 46],
				[1, 53, 23, 37, 54, 24],
				[19, 45, 15, 26, 46, 16],
				[5, 145, 115, 10, 146, 116],
				[19, 75, 47, 10, 76, 48],
				[15, 54, 24, 25, 55, 25],
				[23, 45, 15, 25, 46, 16],
				[13, 145, 115, 3, 146, 116],
				[2, 74, 46, 29, 75, 47],
				[42, 54, 24, 1, 55, 25],
				[23, 45, 15, 28, 46, 16],
				[17, 145, 115],
				[10, 74, 46, 23, 75, 47],
				[10, 54, 24, 35, 55, 25],
				[19, 45, 15, 35, 46, 16],
				[17, 145, 115, 1, 146, 116],
				[14, 74, 46, 21, 75, 47],
				[29, 54, 24, 19, 55, 25],
				[11, 45, 15, 46, 46, 16],
				[13, 145, 115, 6, 146, 116],
				[14, 74, 46, 23, 75, 47],
				[44, 54, 24, 7, 55, 25],
				[59, 46, 16, 1, 47, 17],
				[12, 151, 121, 7, 152, 122],
				[12, 75, 47, 26, 76, 48],
				[39, 54, 24, 14, 55, 25],
				[22, 45, 15, 41, 46, 16],
				[6, 151, 121, 14, 152, 122],
				[6, 75, 47, 34, 76, 48],
				[46, 54, 24, 10, 55, 25],
				[2, 45, 15, 64, 46, 16],
				[17, 152, 122, 4, 153, 123],
				[29, 74, 46, 14, 75, 47],
				[49, 54, 24, 10, 55, 25],
				[24, 45, 15, 46, 46, 16],
				[4, 152, 122, 18, 153, 123],
				[13, 74, 46, 32, 75, 47],
				[48, 54, 24, 14, 55, 25],
				[42, 45, 15, 32, 46, 16],
				[20, 147, 117, 4, 148, 118],
				[40, 75, 47, 7, 76, 48],
				[43, 54, 24, 22, 55, 25],
				[10, 45, 15, 67, 46, 16],
				[19, 148, 118, 6, 149, 119],
				[18, 75, 47, 31, 76, 48],
				[34, 54, 24, 34, 55, 25],
				[20, 45, 15, 61, 46, 16]
			];
			o.prototype.getRightType = function() {
				for(var t = 1; 41 > t; t++) {
					var e = w[4 * (t - 1) + this.errorCorrectLevel];
					if(void 0 == e) throw new Error("bad rs block @ typeNumber:" + t + "/errorCorrectLevel:" + this.errorCorrectLevel);
					for(var i = e.length / 3, n = 0, s = 0; i > s; s++) {
						var o = e[3 * s + 0],
							a = e[3 * s + 2];
						n += a * o
					}
					var r = t > 9 ? 2 : 1;
					if(this.utf8bytes.length + r < n || 40 == t) {
						this.typeNumber = t, this.rsBlock = e, this.totalDataCount = n;
						break
					}
				}
			}, r.prototype = {
				get: function(t) {
					var e = Math.floor(t / 8);
					return this.buffer[e] >>> 7 - t % 8 & 1
				},
				put: function(t, e) {
					for(var i = 0; e > i; i++) this.putBit(t >>> e - i - 1 & 1)
				},
				putBit: function(t) {
					var e = Math.floor(this.length / 8);
					this.buffer.length <= e && this.buffer.push(0), t && (this.buffer[e] |= 128 >>> this.length % 8), this.length++
				}
			}, o.prototype = {
				constructor: o,
				getModuleCount: function() {
					return this.moduleCount
				},
				make: function() {
					this.getRightType(), this.dataCache = this.createData(), this.createQrcode()
				},
				makeImpl: function(t) {
					this.moduleCount = 4 * this.typeNumber + 17, this.modules = new Array(this.moduleCount);
					for(var e = 0; e < this.moduleCount; e++) this.modules[e] = new Array(this.moduleCount);
					this.setupPositionProbePattern(0, 0), this.setupPositionProbePattern(this.moduleCount - 7, 0), this.setupPositionProbePattern(0, this.moduleCount - 7), this.setupPositionAdjustPattern(), this.setupTimingPattern(), this.setupTypeInfo(!0, t), this.typeNumber >= 7 && this.setupTypeNumber(!0), this.mapData(this.dataCache, t)
				},
				setupPositionProbePattern: function(t, e) {
					for(var i = -1; 7 >= i; i++)
						if(!(-1 >= t + i || this.moduleCount <= t + i))
							for(var n = -1; 7 >= n; n++) - 1 >= e + n || this.moduleCount <= e + n || (this.modules[t + i][e + n] = i >= 0 && 6 >= i && (0 == n || 6 == n) || n >= 0 && 6 >= n && (0 == i || 6 == i) || i >= 2 && 4 >= i && n >= 2 && 4 >= n ? !0 : !1)
				},
				createQrcode: function() {
					for(var t = 0, e = 0, i = null, n = 0; 8 > n; n++) {
						this.makeImpl(n);
						var s = f.getLostPoint(this);
						(0 == n || t > s) && (t = s, e = n, i = this.modules)
					}
					this.modules = i, this.setupTypeInfo(!1, e), this.typeNumber >= 7 && this.setupTypeNumber(!1)
				},
				setupTimingPattern: function() {
					for(var t = 8; t < this.moduleCount - 8; t++) null == this.modules[t][6] && (this.modules[t][6] = t % 2 == 0, null == this.modules[6][t] && (this.modules[6][t] = t % 2 == 0))
				},
				setupPositionAdjustPattern: function() {
					for(var t = f.getPatternPosition(this.typeNumber), e = 0; e < t.length; e++)
						for(var i = 0; i < t.length; i++) {
							var n = t[e],
								s = t[i];
							if(null == this.modules[n][s])
								for(var o = -2; 2 >= o; o++)
									for(var a = -2; 2 >= a; a++) this.modules[n + o][s + a] = -2 == o || 2 == o || -2 == a || 2 == a || 0 == o && 0 == a ? !0 : !1
						}
				},
				setupTypeNumber: function(t) {
					for(var e = f.getBCHTypeNumber(this.typeNumber), i = 0; 18 > i; i++) {
						var n = !t && 1 == (e >> i & 1);
						this.modules[Math.floor(i / 3)][i % 3 + this.moduleCount - 8 - 3] = n, this.modules[i % 3 + this.moduleCount - 8 - 3][Math.floor(i / 3)] = n
					}
				},
				setupTypeInfo: function(t, e) {
					for(var i = p[this.errorCorrectLevel] << 3 | e, n = f.getBCHTypeInfo(i), s = 0; 15 > s; s++) {
						var o = !t && 1 == (n >> s & 1);
						6 > s ? this.modules[s][8] = o : 8 > s ? this.modules[s + 1][8] = o : this.modules[this.moduleCount - 15 + s][8] = o;
						var o = !t && 1 == (n >> s & 1);
						8 > s ? this.modules[8][this.moduleCount - s - 1] = o : 9 > s ? this.modules[8][15 - s - 1 + 1] = o : this.modules[8][15 - s - 1] = o
					}
					this.modules[this.moduleCount - 8][8] = !t
				},
				createData: function() {
					var t = new r,
						e = this.typeNumber > 9 ? 16 : 8;
					t.put(4, 4), t.put(this.utf8bytes.length, e);
					for(var i = 0, n = this.utf8bytes.length; n > i; i++) t.put(this.utf8bytes[i], 8);
					for(t.length + 4 <= 8 * this.totalDataCount && t.put(0, 4); t.length % 8 != 0;) t.putBit(!1);
					for(;;) {
						if(t.length >= 8 * this.totalDataCount) break;
						if(t.put(o.PAD0, 8), t.length >= 8 * this.totalDataCount) break;
						t.put(o.PAD1, 8)
					}
					return this.createBytes(t)
				},
				createBytes: function(t) {
					for(var e = 0, i = 0, n = 0, s = this.rsBlock.length / 3, o = new Array, r = 0; s > r; r++)
						for(var l = this.rsBlock[3 * r + 0], c = this.rsBlock[3 * r + 1], u = this.rsBlock[3 * r + 2], h = 0; l > h; h++) o.push([u, c]);
					for(var d = new Array(o.length), p = new Array(o.length), m = 0; m < o.length; m++) {
						var v = o[m][0],
							g = o[m][1] - v;
						i = Math.max(i, v), n = Math.max(n, g), d[m] = new Array(v);
						for(var r = 0; r < d[m].length; r++) d[m][r] = 255 & t.buffer[r + e];
						e += v;
						var w = f.getErrorCorrectPolynomial(g),
							y = new a(d[m], w.getLength() - 1),
							b = y.mod(w);
						p[m] = new Array(w.getLength() - 1);
						for(var r = 0; r < p[m].length; r++) {
							var T = r + b.getLength() - p[m].length;
							p[m][r] = T >= 0 ? b.get(T) : 0
						}
					}
					for(var x = new Array(this.totalDataCount), C = 0, r = 0; i > r; r++)
						for(var m = 0; m < o.length; m++) r < d[m].length && (x[C++] = d[m][r]);
					for(var r = 0; n > r; r++)
						for(var m = 0; m < o.length; m++) r < p[m].length && (x[C++] = p[m][r]);
					return x
				},
				mapData: function(t, e) {
					for(var i = -1, n = this.moduleCount - 1, s = 7, o = 0, a = this.moduleCount - 1; a > 0; a -= 2)
						for(6 == a && a--;;) {
							for(var r = 0; 2 > r; r++)
								if(null == this.modules[n][a - r]) {
									var l = !1;
									o < t.length && (l = 1 == (t[o] >>> s & 1));
									var c = f.getMask(e, n, a - r);
									c && (l = !l), this.modules[n][a - r] = l, s--, -1 == s && (o++, s = 7)
								}
							if(n += i, 0 > n || this.moduleCount <= n) {
								n -= i, i = -i;
								break
							}
						}
				}
			}, o.PAD0 = 236, o.PAD1 = 17;
			for(var p = [1, 0, 3, 2], m = {
					PATTERN000: 0,
					PATTERN001: 1,
					PATTERN010: 2,
					PATTERN011: 3,
					PATTERN100: 4,
					PATTERN101: 5,
					PATTERN110: 6,
					PATTERN111: 7
				}, f = {
					PATTERN_POSITION_TABLE: [
						[],
						[6, 18],
						[6, 22],
						[6, 26],
						[6, 30],
						[6, 34],
						[6, 22, 38],
						[6, 24, 42],
						[6, 26, 46],
						[6, 28, 50],
						[6, 30, 54],
						[6, 32, 58],
						[6, 34, 62],
						[6, 26, 46, 66],
						[6, 26, 48, 70],
						[6, 26, 50, 74],
						[6, 30, 54, 78],
						[6, 30, 56, 82],
						[6, 30, 58, 86],
						[6, 34, 62, 90],
						[6, 28, 50, 72, 94],
						[6, 26, 50, 74, 98],
						[6, 30, 54, 78, 102],
						[6, 28, 54, 80, 106],
						[6, 32, 58, 84, 110],
						[6, 30, 58, 86, 114],
						[6, 34, 62, 90, 118],
						[6, 26, 50, 74, 98, 122],
						[6, 30, 54, 78, 102, 126],
						[6, 26, 52, 78, 104, 130],
						[6, 30, 56, 82, 108, 134],
						[6, 34, 60, 86, 112, 138],
						[6, 30, 58, 86, 114, 142],
						[6, 34, 62, 90, 118, 146],
						[6, 30, 54, 78, 102, 126, 150],
						[6, 24, 50, 76, 102, 128, 154],
						[6, 28, 54, 80, 106, 132, 158],
						[6, 32, 58, 84, 110, 136, 162],
						[6, 26, 54, 82, 110, 138, 166],
						[6, 30, 58, 86, 114, 142, 170]
					],
					G15: 1335,
					G18: 7973,
					G15_MASK: 21522,
					getBCHTypeInfo: function(t) {
						for(var e = t << 10; f.getBCHDigit(e) - f.getBCHDigit(f.G15) >= 0;) e ^= f.G15 << f.getBCHDigit(e) - f.getBCHDigit(f.G15);
						return(t << 10 | e) ^ f.G15_MASK
					},
					getBCHTypeNumber: function(t) {
						for(var e = t << 12; f.getBCHDigit(e) - f.getBCHDigit(f.G18) >= 0;) e ^= f.G18 << f.getBCHDigit(e) - f.getBCHDigit(f.G18);
						return t << 12 | e
					},
					getBCHDigit: function(t) {
						for(var e = 0; 0 != t;) e++, t >>>= 1;
						return e
					},
					getPatternPosition: function(t) {
						return f.PATTERN_POSITION_TABLE[t - 1]
					},
					getMask: function(t, e, i) {
						switch(t) {
							case m.PATTERN000:
								return(e + i) % 2 == 0;
							case m.PATTERN001:
								return e % 2 == 0;
							case m.PATTERN010:
								return i % 3 == 0;
							case m.PATTERN011:
								return(e + i) % 3 == 0;
							case m.PATTERN100:
								return(Math.floor(e / 2) + Math.floor(i / 3)) % 2 == 0;
							case m.PATTERN101:
								return e * i % 2 + e * i % 3 == 0;
							case m.PATTERN110:
								return(e * i % 2 + e * i % 3) % 2 == 0;
							case m.PATTERN111:
								return(e * i % 3 + (e + i) % 2) % 2 == 0;
							default:
								throw new Error("bad maskPattern:" + t)
						}
					},
					getErrorCorrectPolynomial: function(t) {
						for(var e = new a([1], 0), i = 0; t > i; i++) e = e.multiply(new a([1, v.gexp(i)], 0));
						return e
					},
					getLostPoint: function(t) {
						for(var e = t.getModuleCount(), i = 0, n = 0, s = 0; e > s; s++)
							for(var o = 0, a = t.modules[s][0], r = 0; e > r; r++) {
								var l = t.modules[s][r];
								if(e - 6 > r && l && !t.modules[s][r + 1] && t.modules[s][r + 2] && t.modules[s][r + 3] && t.modules[s][r + 4] && !t.modules[s][r + 5] && t.modules[s][r + 6] && (e - 10 > r ? t.modules[s][r + 7] && t.modules[s][r + 8] && t.modules[s][r + 9] && t.modules[s][r + 10] && (i += 40) : r > 3 && t.modules[s][r - 1] && t.modules[s][r - 2] && t.modules[s][r - 3] && t.modules[s][r - 4] && (i += 40)), e - 1 > s && e - 1 > r) {
									var c = 0;
									l && c++, t.modules[s + 1][r] && c++, t.modules[s][r + 1] && c++, t.modules[s + 1][r + 1] && c++, (0 == c || 4 == c) && (i += 3)
								}
								a ^ l ? o++ : (a = l, o >= 5 && (i += 3 + o - 5), o = 1), l && n++
							}
						for(var r = 0; e > r; r++)
							for(var o = 0, a = t.modules[0][r], s = 0; e > s; s++) {
								var l = t.modules[s][r];
								e - 6 > s && l && !t.modules[s + 1][r] && t.modules[s + 2][r] && t.modules[s + 3][r] && t.modules[s + 4][r] && !t.modules[s + 5][r] && t.modules[s + 6][r] && (e - 10 > s ? t.modules[s + 7][r] && t.modules[s + 8][r] && t.modules[s + 9][r] && t.modules[s + 10][r] && (i += 40) : s > 3 && t.modules[s - 1][r] && t.modules[s - 2][r] && t.modules[s - 3][r] && t.modules[s - 4][r] && (i += 40)), a ^ l ? o++ : (a = l, o >= 5 && (i += 3 + o - 5), o = 1)
							}
						var u = Math.abs(100 * n / e / e - 50) / 5;
						return i += 10 * u
					}
				}, v = {
					glog: function(t) {
						if(1 > t) throw new Error("glog(" + t + ")");
						return v.LOG_TABLE[t]
					},
					gexp: function(t) {
						for(; 0 > t;) t += 255;
						for(; t >= 256;) t -= 255;
						return v.EXP_TABLE[t]
					},
					EXP_TABLE: new Array(256),
					LOG_TABLE: new Array(256)
				}, g = 0; 8 > g; g++) v.EXP_TABLE[g] = 1 << g;
			for(var g = 8; 256 > g; g++) v.EXP_TABLE[g] = v.EXP_TABLE[g - 4] ^ v.EXP_TABLE[g - 5] ^ v.EXP_TABLE[g - 6] ^ v.EXP_TABLE[g - 8];
			for(var g = 0; 255 > g; g++) v.LOG_TABLE[v.EXP_TABLE[g]] = g;
			a.prototype = {
				get: function(t) {
					return this.num[t]
				},
				getLength: function() {
					return this.num.length
				},
				multiply: function(t) {
					for(var e = new Array(this.getLength() + t.getLength() - 1), i = 0; i < this.getLength(); i++)
						for(var n = 0; n < t.getLength(); n++) e[i + n] ^= v.gexp(v.glog(this.get(i)) + v.glog(t.get(n)));
					return new a(e, 0)
				},
				mod: function(t) {
					var e = this.getLength(),
						i = t.getLength();
					if(0 > e - i) return this;
					for(var n = new Array(e), s = 0; e > s; s++) n[s] = this.get(s);
					for(; n.length >= i;) {
						for(var o = v.glog(n[0]) - v.glog(t.get(0)), s = 0; s < t.getLength(); s++) n[s] ^= v.gexp(v.glog(t.get(s)) + o);
						for(; 0 == n[0];) n.shift()
					}
					return new a(n, 0)
				}
			}, w = [
				[1, 26, 19],
				[1, 26, 16],
				[1, 26, 13],
				[1, 26, 9],
				[1, 44, 34],
				[1, 44, 28],
				[1, 44, 22],
				[1, 44, 16],
				[1, 70, 55],
				[1, 70, 44],
				[2, 35, 17],
				[2, 35, 13],
				[1, 100, 80],
				[2, 50, 32],
				[2, 50, 24],
				[4, 25, 9],
				[1, 134, 108],
				[2, 67, 43],
				[2, 33, 15, 2, 34, 16],
				[2, 33, 11, 2, 34, 12],
				[2, 86, 68],
				[4, 43, 27],
				[4, 43, 19],
				[4, 43, 15],
				[2, 98, 78],
				[4, 49, 31],
				[2, 32, 14, 4, 33, 15],
				[4, 39, 13, 1, 40, 14],
				[2, 121, 97],
				[2, 60, 38, 2, 61, 39],
				[4, 40, 18, 2, 41, 19],
				[4, 40, 14, 2, 41, 15],
				[2, 146, 116],
				[3, 58, 36, 2, 59, 37],
				[4, 36, 16, 4, 37, 17],
				[4, 36, 12, 4, 37, 13],
				[2, 86, 68, 2, 87, 69],
				[4, 69, 43, 1, 70, 44],
				[6, 43, 19, 2, 44, 20],
				[6, 43, 15, 2, 44, 16],
				[4, 101, 81],
				[1, 80, 50, 4, 81, 51],
				[4, 50, 22, 4, 51, 23],
				[3, 36, 12, 8, 37, 13],
				[2, 116, 92, 2, 117, 93],
				[6, 58, 36, 2, 59, 37],
				[4, 46, 20, 6, 47, 21],
				[7, 42, 14, 4, 43, 15],
				[4, 133, 107],
				[8, 59, 37, 1, 60, 38],
				[8, 44, 20, 4, 45, 21],
				[12, 33, 11, 4, 34, 12],
				[3, 145, 115, 1, 146, 116],
				[4, 64, 40, 5, 65, 41],
				[11, 36, 16, 5, 37, 17],
				[11, 36, 12, 5, 37, 13],
				[5, 109, 87, 1, 110, 88],
				[5, 65, 41, 5, 66, 42],
				[5, 54, 24, 7, 55, 25],
				[11, 36, 12],
				[5, 122, 98, 1, 123, 99],
				[7, 73, 45, 3, 74, 46],
				[15, 43, 19, 2, 44, 20],
				[3, 45, 15, 13, 46, 16],
				[1, 135, 107, 5, 136, 108],
				[10, 74, 46, 1, 75, 47],
				[1, 50, 22, 15, 51, 23],
				[2, 42, 14, 17, 43, 15],
				[5, 150, 120, 1, 151, 121],
				[9, 69, 43, 4, 70, 44],
				[17, 50, 22, 1, 51, 23],
				[2, 42, 14, 19, 43, 15],
				[3, 141, 113, 4, 142, 114],
				[3, 70, 44, 11, 71, 45],
				[17, 47, 21, 4, 48, 22],
				[9, 39, 13, 16, 40, 14],
				[3, 135, 107, 5, 136, 108],
				[3, 67, 41, 13, 68, 42],
				[15, 54, 24, 5, 55, 25],
				[15, 43, 15, 10, 44, 16],
				[4, 144, 116, 4, 145, 117],
				[17, 68, 42],
				[17, 50, 22, 6, 51, 23],
				[19, 46, 16, 6, 47, 17],
				[2, 139, 111, 7, 140, 112],
				[17, 74, 46],
				[7, 54, 24, 16, 55, 25],
				[34, 37, 13],
				[4, 151, 121, 5, 152, 122],
				[4, 75, 47, 14, 76, 48],
				[11, 54, 24, 14, 55, 25],
				[16, 45, 15, 14, 46, 16],
				[6, 147, 117, 4, 148, 118],
				[6, 73, 45, 14, 74, 46],
				[11, 54, 24, 16, 55, 25],
				[30, 46, 16, 2, 47, 17],
				[8, 132, 106, 4, 133, 107],
				[8, 75, 47, 13, 76, 48],
				[7, 54, 24, 22, 55, 25],
				[22, 45, 15, 13, 46, 16],
				[10, 142, 114, 2, 143, 115],
				[19, 74, 46, 4, 75, 47],
				[28, 50, 22, 6, 51, 23],
				[33, 46, 16, 4, 47, 17],
				[8, 152, 122, 4, 153, 123],
				[22, 73, 45, 3, 74, 46],
				[8, 53, 23, 26, 54, 24],
				[12, 45, 15, 28, 46, 16],
				[3, 147, 117, 10, 148, 118],
				[3, 73, 45, 23, 74, 46],
				[4, 54, 24, 31, 55, 25],
				[11, 45, 15, 31, 46, 16],
				[7, 146, 116, 7, 147, 117],
				[21, 73, 45, 7, 74, 46],
				[1, 53, 23, 37, 54, 24],
				[19, 45, 15, 26, 46, 16],
				[5, 145, 115, 10, 146, 116],
				[19, 75, 47, 10, 76, 48],
				[15, 54, 24, 25, 55, 25],
				[23, 45, 15, 25, 46, 16],
				[13, 145, 115, 3, 146, 116],
				[2, 74, 46, 29, 75, 47],
				[42, 54, 24, 1, 55, 25],
				[23, 45, 15, 28, 46, 16],
				[17, 145, 115],
				[10, 74, 46, 23, 75, 47],
				[10, 54, 24, 35, 55, 25],
				[19, 45, 15, 35, 46, 16],
				[17, 145, 115, 1, 146, 116],
				[14, 74, 46, 21, 75, 47],
				[29, 54, 24, 19, 55, 25],
				[11, 45, 15, 46, 46, 16],
				[13, 145, 115, 6, 146, 116],
				[14, 74, 46, 23, 75, 47],
				[44, 54, 24, 7, 55, 25],
				[59, 46, 16, 1, 47, 17],
				[12, 151, 121, 7, 152, 122],
				[12, 75, 47, 26, 76, 48],
				[39, 54, 24, 14, 55, 25],
				[22, 45, 15, 41, 46, 16],
				[6, 151, 121, 14, 152, 122],
				[6, 75, 47, 34, 76, 48],
				[46, 54, 24, 10, 55, 25],
				[2, 45, 15, 64, 46, 16],
				[17, 152, 122, 4, 153, 123],
				[29, 74, 46, 14, 75, 47],
				[49, 54, 24, 10, 55, 25],
				[24, 45, 15, 46, 46, 16],
				[4, 152, 122, 18, 153, 123],
				[13, 74, 46, 32, 75, 47],
				[48, 54, 24, 14, 55, 25],
				[42, 45, 15, 32, 46, 16],
				[20, 147, 117, 4, 148, 118],
				[40, 75, 47, 7, 76, 48],
				[43, 54, 24, 22, 55, 25],
				[10, 45, 15, 67, 46, 16],
				[19, 148, 118, 6, 149, 119],
				[18, 75, 47, 31, 76, 48],
				[34, 54, 24, 34, 55, 25],
				[20, 45, 15, 61, 46, 16]
			], o.prototype.getRightType = function() {
				for(var t = 1; 41 > t; t++) {
					var e = w[4 * (t - 1) + this.errorCorrectLevel];
					if(void 0 == e) throw new Error("bad rs block @ typeNumber:" + t + "/errorCorrectLevel:" + this.errorCorrectLevel);
					for(var i = e.length / 3, n = 0, s = 0; i > s; s++) {
						var o = e[3 * s + 0],
							a = e[3 * s + 2];
						n += a * o
					}
					var r = t > 9 ? 2 : 1;
					if(this.utf8bytes.length + r < n || 40 == t) {
						this.typeNumber = t, this.rsBlock = e, this.totalDataCount = n;
						break
					}
				}
			}, r.prototype = {
				get: function(t) {
					var e = Math.floor(t / 8);
					return this.buffer[e] >>> 7 - t % 8 & 1
				},
				put: function(t, e) {
					for(var i = 0; e > i; i++) this.putBit(t >>> e - i - 1 & 1)
				},
				putBit: function(t) {
					var e = Math.floor(this.length / 8);
					this.buffer.length <= e && this.buffer.push(0), t && (this.buffer[e] |= 128 >>> this.length % 8), this.length++
				}
			}, c.fn.qrcode = function(t) {
				return this.each(function() {
					c(this).append(new d(t))
				})
			}, e.exports = u.qrcode = d
		}, {
			2: 2
		}],
		32: [function(t, e, i) {
			"use strict";

			function n() {
				try {
					return l in r && r[l]
				} catch(t) {
					return !1
				}
			}
			var s, o = t(2),
				a = {},
				r = window,
				l = "localStorage";
			a.disabled = !1, a.version = "1.3.17", a.set = function(t, e) {}, a.get = function(t, e) {}, a.has = function(t) {
				return void 0 !== a.get(t)
			}, a.remove = function(t) {}, a.clear = function() {}, a.transact = function(t, e, i) {
				null == i && (i = e, e = null), null == e && (e = {});
				var n = a.get(t, e);
				i(n), a.set(t, n)
			}, a.getAll = function() {}, a.forEach = function() {}, a.serialize = function(t) {
				return JSON.stringify(t)
			}, a.deserialize = function(t) {
				if("string" != typeof t) return void 0;
				try {
					return JSON.parse(t)
				} catch(e) {
					return t || void 0
				}
			}, n() && (s = r[l], a.set = function(t, e) {
				return void 0 === e ? a.remove(t) : (s.setItem(t, a.serialize(e)), e)
			}, a.get = function(t, e) {
				var i = a.deserialize(s.getItem(t));
				return void 0 === i ? e : i
			}, a.remove = function(t) {
				s.removeItem(t)
			}, a.clear = function() {
				s.clear()
			}, a.getAll = function() {
				var t = {};
				return a.forEach(function(e, i) {
					t[e] = i
				}), t
			}, a.forEach = function(t) {
				for(var e = 0; e < s.length; e++) {
					var i = s.key(e);
					t(i, a.get(i))
				}
			});
			try {
				var c = "__storeJs__";
				a.set(c, c), a.get(c) != c && (a.disabled = !0), a.remove(c)
			} catch(u) {
				a.disabled = !0
			}
			a.enabled = !a.disabled, e.exports = o.store = a
		}, {
			2: 2
		}],
		33: [function(t, e, i) {
			"use strict";

			function n() {
				var t = s('[data-am-widget="accordion"]'),
					e = {
						item: ".am-accordion-item",
						title: ".am-accordion-title",
						body: ".am-accordion-bd",
						disabled: ".am-disabled"
					};
				t.each(function(t, i) {
					var n = o.utils.parseOptions(s(i).attr("data-am-accordion")),
						a = s(i).find(e.title);
					a.on("click.accordion.amui", function() {
						var t = s(this).next(e.body),
							o = s(this).parent(e.item),
							a = t.data("amui.collapse");
						o.is(e.disabled) || (o.toggleClass("am-active"),
							a ? t.collapse("toggle") : t.collapse(), !n.multiple && s(i).children(".am-active").not(o).not(e.disabled).removeClass("am-active").find(e.body + ".am-in").collapse("close"))
					})
				})
			}
			var s = window.jQuery,
				o = t(2);
			t(6), s(n), e.exports = o.accordion = {
				VERSION: "2.1.0",
				init: n
			}
		}, {
			2: 2,
			6: 6
		}],
		34: [function(t, e, i) {
			"use strict";
			e.exports = {
				VERSION: "2.0.1"
			}
		}, {}],
		35: [function(t, e, i) {
			"use strict";

			function n() {
				var t = s(".ds-thread"),
					e = t.parent('[data-am-widget="duoshuo"]').attr("data-ds-short-name"),
					i = ("https:" == document.location.protocol ? "https:" : "http:") + "//static.duoshuo.com/embed.js";
				if(t.length && e && (window.duoshuoQuery = {
						short_name: e
					}, !s('script[src="' + i + '"]').length)) {
					var n = s("<script>", {
						async: !0,
						type: "text/javascript",
						src: i,
						charset: "utf-8"
					});
					s("body").append(n)
				}
			}
			var s = window.jQuery,
				o = t(2);
			s(window).on("load", n), e.exports = o.duoshuo = {
				VERSION: "2.0.1",
				init: n
			}
		}, {
			2: 2
		}],
		36: [function(t, e, i) {
			"use strict";

			function n() {
				s(".am-figure").each(function(t, e) {
					var i, n = o.utils.parseOptions(s(e).attr("data-am-figure")),
						a = s(e);
					if(n.pureview)
						if("auto" === n.pureview) {
							var r = s.isImgZoomAble(a.find("img")[0]);
							r && a.pureview()
						} else a.addClass("am-figure-zoomable").pureview();
					i = a.data("amui.pureview"), i && a.on("click", ":not(img)", function() {
						i.open(0)
					})
				})
			}
			var s = window.jQuery,
				o = t(2);
			t(17), s.isImgZoomAble = function(t) {
				var e = new Image;
				e.src = t.src;
				var i = s(t).width() < e.width;
				return i && s(t).closest(".am-figure").addClass("am-figure-zoomable"), i
			}, s(window).on("load", n), e.exports = o.figure = {
				VERSION: "2.0.3",
				init: n
			}
		}, {
			17: 17,
			2: 2
		}],
		37: [function(t, e, i) {
			"use strict";

			function n() {
				s(".am-footer-ysp").on("click", function() {
					s("#am-footer-modal").modal()
				});
				var t = o.utils.parseOptions(s(".am-footer").data("amFooter"));
				t.addToHS && a(), s('[data-rel="desktop"]').on("click", function(t) {
					t.preventDefault(), window.AMPlatform ? window.AMPlatform.util.goDesktop() : (r.set("allmobilize", "desktop", "", "/"), window.location = window.location)
				})
			}
			var s = window.jQuery,
				o = t(2);
			t(12);
			var a = t(3),
				r = t(27);
			s(n), e.exports = o.footer = {
				VERSION: "3.1.2",
				init: n
			}
		}, {
			12: 12,
			2: 2,
			27: 27,
			3: 3
		}],
		38: [function(t, e, i) {
			"use strict";

			function n() {
				var t = s('[data-am-widget="gallery"]');
				t.each(function() {
					var t = o.utils.parseOptions(s(this).attr("data-am-gallery"));
					t.pureview && ("object" == typeof t.pureview ? s(this).pureview(t.pureview) : s(this).pureview())
				})
			}
			var s = window.jQuery,
				o = t(2);
			t(17), s(n), e.exports = o.gallery = {
				VERSION: "3.0.0",
				init: n
			}
		}, {
			17: 17,
			2: 2
		}],
		39: [function(t, e, i) {
			"use strict";

			function n() {
				function t() {
					i[(n.scrollTop() > 50 ? "add" : "remove") + "Class"]("am-active")
				}
				var e = s('[data-am-widget="gotop"]'),
					i = e.filter(".am-gotop-fixed"),
					n = s(window);
				e.data("init") || (e.find("a").on("click", function(t) {
					t.preventDefault(), n.smoothScroll()
				}), t(), n.on("scroll.gotop.amui", o.utils.debounce(t, 100)), e.data("init", !0))
			}
			var s = window.jQuery,
				o = t(2);
			t(22), s(n), e.exports = o.gotop = {
				VERSION: "4.0.2",
				init: n
			}
		}, {
			2: 2,
			22: 22
		}],
		40: [function(t, e, i) {
			"use strict";

			function n() {
				s('[data-am-widget="header"]').each(function() {
					return s(this).hasClass("am-header-fixed") ? (s("body").addClass("am-with-fixed-header"), !1) : void 0
				})
			}
			var s = window.jQuery,
				o = t(2);
			s(n), e.exports = o.header = {
				VERSION: "2.0.0",
				init: n
			}
		}, {
			2: 2
		}],
		41: [function(t, e, i) {
			"use strict";
			var n = t(2);
			e.exports = n.intro = {
				VERSION: "4.0.2",
				init: function() {}
			}
		}, {
			2: 2
		}],
		42: [function(t, e, i) {
			"use strict";
			var n = t(2);
			e.exports = n.listNews = {
				VERSION: "4.0.0",
				init: function() {}
			}
		}, {
			2: 2
		}],
		43: [function(t, e, i) {
			function n(t) {
				var e = o("<script />", {
					id: "am-map-api-0"
				});
				o("body").append(e), e.on("load", function() {
					console.log("load");
					var e = o("<script/>", {
						id: "am-map-api-1"
					});
					o("body").append(e), e.on("load", function() {
						var e = document.createElement("script");
						e.textContent = "(" + t.toString() + ")();", o("body")[0].appendChild(e)
					}).attr("src", "http://api.map.baidu.com/getscript?type=quick&file=feature&ak=WVAXZ05oyNRXS5egLImmentg&t=20140109092002")
				}).attr("src", "http://api.map.baidu.com/getscript?type=quick&file=api&ak=WVAXZ05oyNRXS5egLImmentg&t=20140109092002")
			}

			function s() {
				var t = document.querySelector(".am-map"),
					e = 116.331398,
					i = 39.897445,
					n = t.getAttribute("data-name"),
					s = t.getAttribute("data-address"),
					o = t.getAttribute("data-longitude") || e,
					a = t.getAttribute("data-latitude") || i,
					r = t.getAttribute("data-setZoom") || 17,
					l = t.getAttribute("data-icon"),
					c = new BMap.Map("bd-map"),
					u = new BMap.Point(o, a);
				c.centerAndZoom(u, r), t.getAttribute("data-zoomControl") && c.addControl(new BMap.ZoomControl), t.getAttribute("data-scaleControl") && c.addControl(new BMap.ScaleControl);
				var h = new BMap.Marker(u);
				l && h.setIcon(new BMap.Icon(l, new BMap.Size(40, 40)));
				var d = {
						width: 200,
						title: n
					},
					p = new BMap.InfoWindow("\u5730\u5740\uff1a" + s, d),
					m = new BMap.Geocoder;
				o == e && a == i ? m.getPoint(s, function(t) {
					t && (c.centerAndZoom(t, r), h.setPosition(t), c.addOverlay(h), c.openInfoWindow(p, t))
				}, "") : m.getLocation(u, function(t) {
					c.centerAndZoom(u, r), h.setPosition(u), c.addOverlay(h), s ? c.openInfoWindow(p, u) : c.openInfoWindow(new BMap.InfoWindow(s, d), u)
				})
			}
			var o = window.jQuery,
				a = t(2),
				r = function() {
					o(".am-map").length && n(s)
				};
			o(r), e.exports = a.map = {
				VERSION: "2.0.2",
				init: r
			}
		}, {
			2: 2
		}],
		44: [function(t, e, i) {
			"use strict";

			function n() {
				if(s("#mechat").length) {
					var t = s('[data-am-widget="mechat"]'),
						e = t.data("am-mechat-unitid"),
						i = s("<script>", {
							charset: "utf-8",
							src: "http://mechatim.com/js/unit/button.js?id=" + e
						});
					s("body").append(i)
				}
			}
			var s = window.jQuery,
				o = t(2);
			s(window).on("load", n), e.exports = o.mechat = {
				VERSION: "2.0.1",
				init: n
			}
		}, {
			2: 2
		}],
		45: [function(t, e, i) {
			"use strict";
			var n = window.jQuery,
				s = t(2),
				o = t(11);
			t(13), t(6);
			var a = function() {
				var t = n('[data-am-widget="menu"]');
				t.find(".am-menu-nav .am-parent > a").on("click", function(t) {
					t.preventDefault();
					var e = n(this),
						i = e.parent(),
						s = e.next(".am-menu-sub");
					i.toggleClass("am-open"), s.collapse("toggle"), i.siblings(".am-parent").removeClass("am-open").children(".am-menu-sub.am-in").collapse("close")
				}), t.filter("[data-am-menu-collapse]").find("> .am-menu-toggle").on("click", function(t) {
					t.preventDefault();
					var e = n(this),
						i = e.next(".am-menu-nav");
					e.toggleClass("am-active"), i.collapse("toggle")
				}), t.filter("[data-am-menu-offcanvas]").find("> .am-menu-toggle").on("click", function(t) {
					t.preventDefault();
					var e = n(this),
						i = e.next(".am-offcanvas");
					e.toggleClass("am-active"), i.offCanvas("open")
				});
				var e = '.am-offcanvas[data-dismiss-on="click"]',
					i = n(e);
				i.find("a").not(".am-parent>a").on("click", function(t) {
					n(this).parents(e).offCanvas("close")
				}), t.filter(".am-menu-one").each(function(t) {
					var e, i = n(this),
						s = n('<div class="am-menu-nav-sub-wrap"></div>'),
						a = 0,
						r = i.find(".am-menu-nav"),
						l = r.children("li");
					l.filter(".am-parent").each(function(t) {
						n(this).attr("data-rel", "#am-menu-sub-" + t), n(this).find(".am-menu-sub").attr("id", "am-menu-sub-" + t).appendTo(s)
					}), i.append(s), r.wrap('<div class="am-menu-nav-wrap" id="am-menu-' + t + '">'), l.each(function(t) {
						a += parseFloat(n(this).css("width"))
					}), r.width(a);
					var c = new o("#am-menu-" + t, {
						eventPassthrough: !0,
						scrollX: !0,
						scrollY: !1,
						preventDefault: !1
					});
					l.on("click", function() {
						var t = n(this);
						t.addClass("am-active").siblings().removeClass("am-active"), s.find(".am-menu-sub.am-in").collapse("close"), t.is(".am-parent") ? !t.hasClass(".am-open") && s.find(t.attr("data-rel")).collapse("open") : t.siblings().removeClass("am-open"), void 0 === e && (e = n(this).index() ? 0 : 1);
						var o, a = n(this).index() > e,
							l = n(this)[a ? "next" : "prev"](),
							u = l.offset() || n(this).offset(),
							h = i.offset(),
							d = parseInt(i.css("padding-left"));
						(a ? u.left + u.width > h.left + h.width : u.left < h.left) && (o = r.offset(), c.scrollTo(a ? h.width - u.left + o.left - u.width - d : o.left - u.left, 0, 400)), e = n(this).index()
					}), i.on("touchmove", function(t) {
						t.preventDefault()
					})
				})
			};
			n(a), e.exports = s.menu = {
				VERSION: "4.0.3",
				init: a
			}
		}, {
			11: 11,
			13: 13,
			2: 2,
			6: 6
		}],
		46: [function(t, e, i) {
			"use strict";

			function n() {
				function t() {
					u.append(b), u.find("li").not(".am-navbar-more").slice(i() - 1).appendTo(y), n.append(y)
				}

				function e() {
					return i() >= d ? (b.hide(), void y.find("li").insertBefore(b)) : (!n.find(".am-navbar-actions").length && t(), b.show(), void(u.find("li").length < i() ? y.find("li").slice(0, i() - u.find("li").length).insertBefore(b) : u.find("li").length > i() && (y.find("li").length ? u.find("li").not(b).slice(i() - 1).insertBefore(y.find("li").first()) : u.find("li").not(b).slice(i() - 1).appendTo(y))))
				}

				function i() {
					return Math.floor((l.width() - f) / m)
				}
				var n = s('[data-am-widget="navbar"]');
				if(n.length) {
					var l = s(window),
						c = s("body"),
						u = n.find(".am-navbar-nav"),
						h = n.find("li"),
						d = h.length,
						p = u.attr("class") && parseInt(u.attr("class").match(/am-avg-sm-(\d+)/)[1]) || 3,
						m = 60,
						f = 16,
						v = h.filter("[data-am-navbar-share]"),
						g = h.filter("[data-am-navbar-qrcode]"),
						w = "am-active",
						y = s('<ul class="am-navbar-actions"></ul>', {
							id: o.utils.generateGUID("am-navbar-actions")
						}),
						b = s('<li class="am-navbar-labels am-navbar-more"><a href="javascript: void(0);"><span class="am-icon-angle-up"></span><span class="am-navbar-label">\u66f4\u591a</span></a></li>');
					if("fixed" == n.css("position") && c.addClass("am-with-fixed-navbar"), g.length) {
						var T = "am-navbar-qrcode";
						if(C = s("#" + T), !C.length) {
							var x = g.attr("data-am-navbar-qrcode"),
								C = s('<div class="am-modal am-modal-no-btn" id=""><div class="am-modal-dialog"><div class="am-modal-bd"></div></div></div>', {
									id: T
								}),
								E = C.find(".am-modal-bd");
							if(x) E.html('<img src="' + x + '"/>');
							else {
								var S = new r({
									render: "canvas",
									correctLevel: 0,
									text: window.location.href,
									width: 200,
									height: 200,
									background: "#fff",
									foreground: "#000"
								});
								E.html(S)
							}
							c.append(C)
						}
						g.on("click", function(t) {
							t.preventDefault(), C.modal()
						})
					}
					d > p && d > i() && t(), n.on("click.navbar.amui", ".am-navbar-more", function(t) {
						t.preventDefault(), b[y.hasClass(w) ? "removeClass" : "addClass"](w), y.toggleClass(w)
					}), v.length && v.on("click.navbar.amui", function(t) {
						t.preventDefault(), a.toggle()
					}), l.on("resize.navbar.amui orientationchange.navbar.amui", o.utils.debounce(e, 150))
				}
			}
			var s = window.jQuery,
				o = t(2),
				a = t(21),
				r = t(31);
			t(12), s(n), e.exports = o.navbar = {
				VERSION: "2.0.2",
				init: n
			}
		}, {
			12: 12,
			2: 2,
			21: 21,
			31: 31
		}],
		47: [function(t, e, i) {
			"use strict";
			var n = t(2);
			e.exports = n.pagination = {
				VERSION: "3.0.1"
			}
		}, {
			2: 2
		}],
		48: [function(t, e, i) {
			"use strict";

			function n() {
				var t = s('[data-am-widget="paragraph"]');
				t.each(function(t) {
					var e = s(this),
						i = o.utils.parseOptions(e.attr("data-am-paragraph")),
						n = t;
					i.pureview && e.pureview(), i.tableScrollable && e.find("table").each(function(t) {
						s(this).width() > s(window).width() && s(this).scrollTable(n + "-" + t)
					})
				})
			}
			var s = window.jQuery,
				o = t(2),
				a = t(11);
			t(17), s.fn.scrollTable = function(t) {
				var e, i = s(this);
				i.wrap('<div class="am-paragraph-table-container" id="am-paragraph-table-' + t + '"><div class="am-paragraph-table-scroller"></div></div>'), e = i.parent(), e.width(i.width()), e.height(i.height()), new a("#am-paragraph-table-" + t, {
					eventPassthrough: !0,
					scrollX: !0,
					scrollY: !1,
					preventDefault: !1
				})
			}, s(window).on("load", n), e.exports = o.paragraph = {
				VERSION: "2.0.1",
				init: n
			}
		}, {
			11: 11,
			17: 17,
			2: 2
		}],
		49: [function(t, e, i) {
			"use strict";

			function n() {
				var t = s('[data-am-widget="slider"]');
				t.not(".am-slider-manual").each(function(t, e) {
					var i = o.utils.parseOptions(s(e).attr("data-am-slider"));
					s(e).flexslider(i)
				})
			}
			var s = window.jQuery,
				o = t(2);
			t(10), s(n), e.exports = o.slider = {
				VERSION: "3.0.1",
				init: n
			}
		}, {
			10: 10,
			2: 2
		}],
		50: [function(t, e, i) {
			"use strict";

			function n() {
				s('[data-am-widget="tabs"]').each(function() {
					var t = s(this).data("amTabsNoswipe") ? {
						noSwipe: 1
					} : {};
					s(this).tabs(t)
				})
			}
			var s = window.jQuery,
				o = t(2);
			t(24), s(n), e.exports = o.tab = {
				VERSION: "4.0.1",
				init: n
			}
		}, {
			2: 2,
			24: 24
		}],
		51: [function(t, e, i) {
			"use strict";
			var n = t(2);
			e.exports = n.titlebar = {
				VERSION: "4.0.1"
			}
		}, {
			2: 2
		}],
		52: [function(t, e, i) {
			"use strict";

			function n() {
				var t = s('[data-am-widget="wechatpay"]');
				return a ? void t.on("click", ".am-wechatpay-btn", function(t) {
					t.preventDefault();
					var e = o.utils.parseOptions(s(this).parent().data("wechatPay"));
					return window.wx ? void wx.checkJsApi({
						jsApiList: ["chooseWXPay"],
						success: function(t) {
							t.checkResult.chooseWXPay ? wx.chooseWXPay(e) : alert("\u5fae\u4fe1\u7248\u672c\u4e0d\u652f\u6301\u652f\u4ed8\u63a5\u53e3\u6216\u6ca1\u6709\u5f00\u542f\uff01")
						},
						fail: function() {
							alert("\u8c03\u7528 checkJsApi \u63a5\u53e3\u65f6\u53d1\u751f\u9519\u8bef!")
						}
					}) : void alert("\u6ca1\u6709\u5fae\u4fe1 JS SDK")
				}) : (t.hide(), !1)
			}
			var s = window.jQuery,
				o = t(2),
				a = window.navigator.userAgent.indexOf("MicroMessenger") > -1,
				r = n;
			s(r), e.exports = o.pay = {
				VERSION: "1.0.0",
				init: r
			}
		}, {
			2: 2
		}]
	}, {}, [1])(1)
});
// empty