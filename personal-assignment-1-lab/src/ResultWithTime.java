class ResultWithTime<T> {
    T result; // for store the result of operation
    long duration; // for store execute time of operation

    ResultWithTime(T result, long duration) {
        this.result = result;
        this.duration = duration;
    }
}