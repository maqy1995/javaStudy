//import com.sun.javafx.geom.Edge;
//import sun.security.provider.certpath.Vertex;
//
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.HashSet;
//import java.util.List;
//
///**
// * enum Mode {
// *    SEQUENTIAL,
// *    CONCURRENT
// * }
// * class Edge {
// *    Vertex getSource() {}
// *    Vertex getTarget() {}
// *    Mode getMode() {}
// * }
// * class Vertex {
// *    List<Edge> getInputs() {}
// *    List<Edge> getOutputs() {}
// * }
// * Collection<Collection<Vertex>> getAllConcurrentSets(List<Vertex> vertices) {
// * }
// */
//public class GetAllConcurrentSets {
//    HashSet<Vertex> finished = new HashSet<>();//用来存放已经访问过的节点
//    Collection<Collection<Vertex>> result = new ArrayList<>();//最终结果，全局的
//
//    public void visitPre(Vertex vertex,Collection concurrentSet){
//        if(!concurrentSet.isEmpty()){
//            //当前的一个Concurrent集合非空，则判断是否在result中
//            if(!result.contains(concurrentSet)){
//                //没有在result中,则加入
//                result.add(concurrentSet);
//            }
//        }
//        List<Edge> edges = vertex.getInputs();
//        for(Edge edge : edges){
//            if(edge.getMode()==Mode.CONCURRENT){
//                if(!concurrentSet.contains(vertex)){//如果该节点没加入的话
//                    concurrentSet.add(vertex);
//                }
//                concurrentSet.add(edge.getSource);//加入前驱
//                //递归遍历前序节点
//                visitPre(edge.getSource(),concurrentSet);
//            }else {
//                //新建一个Collection，然后继续遍历
//                visitPre(edge.getSource(),new ArrayList());
//            }
//        }
//    }
//
//    public void visitNext(Vertex vertex,Collection concurrentSet){
//        if(!concurrentSet.isEmpty()){
//            //当前的一个Concurrent集合非空，则判断是否在result中
//            if(!result.contains(concurrentSet)){
//                //没有在result中,则加入
//                result.add(concurrentSet);
//            }
//        }
//        List<Edge> edges = vertex.getOutputs();
//        for(Edge edge : edges){
//            if(edge.getMode()==Mode.CONCURRENT){
//                if(!concurrentSet.has(vertex)){//该节点没加入的话
//                    concurrentSet.add(vertex);
//                }
//                concurrentSet.add(edge.getTarget());
//                //递归遍历后续节点
//                visitNext(edge.getTarget(),concurrentSet);
//            }else {
//                visitNext(edge.getTarget(),new ArrayList());
//            }
//        }
//    }
//
//    public Collection<Collection<Vertex>> getAllConcurrentSets(List<Vertex> vertices) {
//        for(Vertex vertex : vertices){
//            //判断是否都遍历过了
//            if(finished.size()==vertices.size()){
//                break;
//            }
//            //如果当前vertex没有被遍历过
//            if(!finished.contains(vertex)){
//                //加入到已经遍历过的节点
//                finished.add(vertex);
//                Collection<Vertex> concurrentSet = new ArrayList<>();
//                visitPre(vertex,concurrentSet);
//                visitNext(vertex,concurrentSet);
//            }
//        }
//        return this.result;
//    }
//}
