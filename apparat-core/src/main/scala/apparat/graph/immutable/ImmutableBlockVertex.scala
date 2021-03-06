/*
 * This file is part of Apparat.
 *
 * Copyright (C) 2010 Joa Ebert
 * http://www.joa-ebert.com/
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA
 */
package apparat.graph.immutable

import apparat.graph.BlockVertex
import apparat.bytecode.operations.AbstractOp

class ImmutableBlockVertex[T](val block: List[T] = Nil) extends BlockVertex[T] with Immutable {
	override def ++(elms: List[T]) = new ImmutableBlockVertex(block ::: elms)

	override def removeFirst = new ImmutableBlockVertex(block.tail)

	override def removeLast = new ImmutableBlockVertex(block dropRight 1)

	override def clear = new ImmutableBlockVertex()
}

class ImmutableAbstractOpBlockVertex(block: List[AbstractOp] = Nil) extends ImmutableBlockVertex[AbstractOp](block) {
	override def ++(elms: List[AbstractOp]) = new ImmutableAbstractOpBlockVertex(block ::: elms)

	override def toString = block.mkString("[[", "\\n", "]]")
}
