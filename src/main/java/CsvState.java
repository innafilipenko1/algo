public enum CsvState {
    Coma {
        @Override
        public CsvState next(char c, ParseData data) {
            if (c == '"') {
                return Q;
            }
            if (c == '\n') {

            }
            return InvalidEnd;
        }
    }, Q {
        @Override
        public CsvState next(char c, ParseData data) {
            return null;
        }
    }, Cell {
        @Override
        public CsvState next(char c, ParseData data) {
            return null;
        }
    }, BreakLine {
        @Override
        public CsvState next(char c, ParseData data) {
            return null;
        }
    }, InvalidEnd {
        @Override
        public CsvState next(char c, ParseData data) {
            return null;
        }
    }, Init {
        @Override
        public CsvState next(char c, ParseData data) {
            return null;
        }
    };
    public abstract CsvState next(char c, ParseData data);
}
