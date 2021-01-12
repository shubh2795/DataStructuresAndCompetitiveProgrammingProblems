//package graphs.heap;
//
//
//import java.util.*;
//
//public class MinHeap<Integer, Integer> {
//
//
//    private Map.Entry[] _heap;
//    private int _count = 0;
//    private HashMap<Integer, Integer> _heapIndex;
//    private static final int BufferSize = 100;
//
//
//    public MinHeap() {
//        this._heap = new KeyValuePair[BufferSize];
//        this._heapIndex = new HashMap<Integer, Integer>(BufferSize);
//    }
//
//
//    public MinHeap(int capacity) {
//        this._heap = new KeyValuePair[capacity];
//        this._heapIndex = new HashMap<Integer, Integer>(capacity);
//    }
//
//
//    public final int getCount() {
//        return _count;
//    }
//
//    public final void Insert(Integer key, TValue value) {
//        Map.Entry kvp = new KeyValuePair(key, value);
//        _heapIndex.put(key, _count);
//        _heap[_count++] = kvp;
//        BubbleUp(_count - 1);
//    }
//
//    public final void Delete(Integer key) {
//        int nodeIndex = _heapIndex.get(key);
//        Map.Entry kvp = _heap[--_count];
//        _heap[nodeIndex] = kvp;
//        _heapIndex.put(kvp.getKey(), nodeIndex);
//        _heapIndex.remove(key);
//        int parentIndex = GetParentIndex(nodeIndex);
//        boolean bubbleUp = false;
//        if (parentIndex > 0) {
//            Map.Entry parentNode = _heap[parentIndex];
//            if (kvp.getValue().CompareTo(parentNode.getValue()) < 0) {
//                Swap(nodeIndex, parentIndex);
//                _heapIndex.put(key, parentIndex);
//                _heapIndex.put(parentNode.getKey(), nodeIndex);
//                BubbleUp(parentIndex);
//                bubbleUp = true;
//            }
//        }
//        if (!bubbleUp) {
//            if (_count > (nodeIndex + 1)) {
//                BubbleDown(nodeIndex);
//            }
//        }
//    }
//
//    public final Map.Entry Find(Integer key) {
//        if (_heapIndex.containsKey(key)) {
//            return _heap[_heapIndex.get(key)];
//        }
//        return null;
//    }
//
//    private void BubbleUp(int nodeIndex) {
//        if (nodeIndex != 0) {
//            int parentIndex = GetParentIndex(nodeIndex);
//
//            var node = _heap[nodeIndex];
//
//            var parentNode = _heap[parentIndex];
//            if (parentNode.Value.CompareTo(node.Value) > 0) {
//                Swap(nodeIndex, parentIndex);
//                _heapIndex[node.Key] = parentIndex;
//                _heapIndex[parentNode.Key] = nodeIndex;
//                BubbleUp(parentIndex);
//            }
//        }
//    }
//
//
//    public final void Update(Integer key, TValue value) {
//
//        var nodeIndex = _heapIndex[key];
//        _heap[nodeIndex].Value = value;
//
//        int parentIndex = GetParentIndex(nodeIndex);
//        boolean bubbleUp = false;
//        if (parentIndex >= 0) {
//
//            var parentNode = _heap[parentIndex];
//            if (parentNode.Value.CompareTo(value) > 0) {
//                Swap(nodeIndex, parentIndex);
//                _heapIndex[key] = parentIndex;
//                _heapIndex[parentNode.Key] = nodeIndex;
//                BubbleUp(parentIndex);
//                bubbleUp = true;
//            }
//        }
//        if (!bubbleUp) {
//            int minIndex = GetMinChildIndex(nodeIndex);
//            if (minIndex > 0) {
//
//                var minNode = _heap[minIndex];
//                if (value.CompareTo(minNode.Value) > 0) {
//                    Swap(nodeIndex, minIndex);
//                    _heapIndex[key] = minIndex;
//                    _heapIndex[minNode.Key] = nodeIndex;
//                    BubbleDown(minIndex);
//                }
//            }
//        }
//    }
//
//    public final Map.Entry ExtractMin() {
//        Map.Entry min = _heap[0];
//        _count--;
//        if (_count > 0) {
//
//            var kvp = _heap[_count];
//            _heap[0] = kvp;
//            Integer key = _heap[0].Key;
//            _heapIndex[key] = 0;
//            _heapIndex.Remove(min.getKey());
//            if (_count > 1) {
//                BubbleDown(0);
//            }
//        }
//        return min;
//    }
//
//
//    private void BubbleDown(int nodeIndex) {
//
//        var node = _heap[nodeIndex];
//        int minIndex = GetMinChildIndex(nodeIndex);
//        if (minIndex > 0) {
//
//            var minNode = _heap[minIndex];
//            if (node.Value.CompareTo(minNode.Value) > 0) {
//                Swap(minIndex, nodeIndex);
//                _heapIndex[node.Key] = minIndex;
//                _heapIndex[minNode.Key] = nodeIndex;
//                BubbleDown(minIndex);
//            }
//        }
//    }
//
//    private void Swap(int node1, int node2) {
//
//        var tmpNode = _heap[node1];
//        _heap[node1] = _heap[node2];
//        _heap[node2] = tmpNode;
//    }
//
//    private int GetParentIndex(int index) {
//        return (index + 1) / 2 - 1;
//    }
//
//    private int GetChildStartIndex(int index) {
//        return index * 2 + 1;
//    }
//
//    private int GetChildEndIndex(int index) {
//        return index * 2 + 2;
//    }
//
//    private int GetMinChildIndex(int index) {
//        int startIndex = GetChildStartIndex(index);
//        if (startIndex >= _count) {
//            return -1;
//        }
//        int endIndex = GetChildEndIndex(index);
//        if (endIndex >= _count) {
//            return startIndex;
//        }
//        return (_heap[startIndex].Value.CompareTo(_heap[endIndex].Value) < 0) ? startIndex : endIndex;
//    }
//
//
//    static int SingleSourceShortestPathForNonNegativeEdgeLength(Vertex v)
//    {
//        int min = short.MaxValue;
//        var crossingEdges = new MinHeap<short, short>(N);
//        var minVertices = new bool[N];
//        minVertices[v.Id - 1] = true;
//
//        foreach (var outgoingEdge in v.OutgoingEdges)
//        {
//            // Use a Heapify operation!
//            crossingEdges.Insert(outgoingEdge.V2, outgoingEdge.Length);
//        }
//
//        while (crossingEdges.Count > 0)
//        {
//            var minEdge = crossingEdges.ExtractMin();
//
//            short v2 = minEdge.Key;
//            var newVertex = vertices[v2 - 1];
//            minVertices[v2 - 1] = true;
//            if (minEdge.Value < min)
//                min = minEdge.Value;
//
//            foreach (var newEdge in newVertex.OutgoingEdges)
//            {
//                if (minVertices[newEdge.V2 - 1])
//                    continue;
//
//                var edgeLength = (short)(newEdge.Length + minEdge.Value);
//
//                var edge = crossingEdges.Find(newEdge.V2);
//                if (edge!=null)
//                {
//                    if (edgeLength < edge.Value)
//                        crossingEdges.Update(newEdge.V2, edgeLength);
//                }
//                else
//                {
//                    crossingEdges.Insert(newEdge.V2, edgeLength);
//                }
//            }
//        }
//        return min;
//    }
//
//
//
//
//}
