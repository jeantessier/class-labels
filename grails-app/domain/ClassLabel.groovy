class ClassLabel {

    ConsistencyState consistencyState
    String clusterId

    static hasMany = [ children: ClassLabel ]

    static belongsTo = [ parent: ClassLabel ]

    static constraints = {
        clusterId nullable: true
    }

    static getCurrentList() {
        ClassLabel.where { parent == null }.list()
    }

    def getLeaves() {
        if (children) {
            children*.leaves.flatten()
        } else {
            return [ this ]
        }
    }

}
