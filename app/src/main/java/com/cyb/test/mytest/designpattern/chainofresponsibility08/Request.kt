package com.cyb.test.mytest.designpattern.chainofresponsibility08

class Request {
    var name: String? = null
    var reason: String? = null
    var days: Int? = 0

    constructor(builder: Builder) {
        name = builder.name
        reason = builder.reason
        days = builder.days
    }

    class Builder {
        var name: String? = null
        var reason: String? = null
        var days: Int? = 0

        fun setName(name: String): Builder {
            this.name = name;
            return this;
        }

        fun setReason(reason: String): Builder {
            this.reason = reason;
            return this;
        }

        fun setDays(days: Int): Builder {
            this.days = days;
            return this;
        }

        fun newRequest(request: Request): Builder {
            this.name = request.name
            this.reason = request.reason
            this.days = request.days

            return this
        }

        fun build(): Request {
            return Request(this);
        }

        override fun toString(): String {
            return "Builder(name=$name, reason=$reason, days=$days)"
        }


    }

    override fun toString(): String {
        return "Request(name=$name, reason=$reason, days=$days)"
    }


}

